package CashManager.controllers;

import CashManager.dto.payement.PaymentCardDto;
import CashManager.dto.payement.PaymentChequeDto;
import CashManager.exception.EntityNotFoundException;
import CashManager.exception.InvalidChequeValueException;
import CashManager.exception.MaxAttemptException;
import CashManager.models.order.Order;
import CashManager.models.payement.Payement;
import CashManager.models.payement.PayementInfo;
import CashManager.models.payement.PayementType;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import CashManager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class PayementController {

    @Autowired
    private PayementService payementService;

    @Autowired
    private PayementTypeService payementTypeService;

    @Autowired
    private PayementInfoService payementInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Value("${payment.maxAttempt}")
    private int maxAttempt;

    @GetMapping("/payement/{id}")
    public Payement show(@PathVariable String id) {
        int payementId = Integer.parseInt(id);
        return this.payementService.getPayementById(payementId);
    }

    @PostMapping("/payement")
    public Payement create(@RequestBody Map<String, String> body) {
        PayementType payementType = payementTypeService.getPayementTypeById(Integer.parseInt(body.get("payementType")));
        PayementInfo payementInfo = payementInfoService.getPayementInfoById(Integer.parseInt(body.get("payementInfo")));
        return this.payementService.addNewPayement(
                Payement.builder()
                        .payementInfo(payementInfo)
                        .payementType(payementType)
                        .build());
    }

    @PostMapping("/payement/{id}")
    public Payement createUserPayement(@RequestBody Map<String, String> body,@PathVariable String id) {
        PayementType payementType = payementTypeService.getPayementTypeById(Integer.parseInt(body.get("payementType")));
        PayementInfo payementInfo = payementInfoService.getPayementInfoById(Integer.parseInt(body.get("payementInfo")));
        Payement payement = Payement.builder()
                .payementInfo(payementInfo)
                .payementType(payementType)
                .build();
        this.payementService.addNewPayement(payement);

        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        List<Payement> payementList = customer.getPayements();
        payementList.add(payement);
        customer.setPayements(payementList);
        this.customerService.editCustomer(customer);

        return payement;
    }


    /**
     * Pay an order using a cheque. Number of payment attempt is limited.
     * @param dto DTO for the cheque data
     * @return 200 if success, 404 if order not found, 400 if invalid payment
     */
    @PostMapping("/payement/cheque")
    public ResponseEntity orderPaymentbyCheque(@RequestBody PaymentChequeDto dto) {
        Order order = orderService.getOrderById(dto.getOrderId());
        Customer customer = customerService.getCustomerById(dto.getCustomerId());

        System.out.println("Payment by cheque");
        System.out.println(dto.getChequeValue());
        System.out.println(dto.getId());

        checkEntitiesExist(order, customer);
        checkAttempt(order);
        if (dto.getChequeValue() != order.getTotal()) {
            order.setPaymentAttempt(order.getPaymentAttempt() + 1);
            orderService.editOrder(order);
            throw new InvalidChequeValueException();
        }

        Payement payment = new Payement();
        orderService.setPayment(order, payment);
        customerService.clearCart(customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Pay an order using a card. Number of payment attempt is limited.
     * @param dto DTO for the cheque data
     * @throws EntityNotFoundException 404: order or customer was not found
     * @return 200 if success, 404 if order not found, 400 if invalid payment
     */
    @PostMapping("/payement/card")
    public ResponseEntity orderPaymentbyCard(@RequestBody PaymentCardDto dto) {
        Order order = orderService.getOrderById(dto.getOrderId());
        Customer customer = customerService.getCustomerById(dto.getCustomerId());
        Payement payment = new Payement();

        checkEntitiesExist(order, customer);
        checkAttempt(order);
        orderService.setPayment(order, payment);
        customerService.clearCart(customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Check if the max amount of payment has been reached
     * @param order Order with number of previous payment attempts
     * @throws MaxAttemptException 400 Bad request: Max payment attempts reached
     */
    private void checkAttempt(Order order) {
        if (order.getPaymentAttempt() >= maxAttempt)
            throw new MaxAttemptException();
    }

    /**
     * Test if the entities exist. Throw exception otherwise
     * @param order Order
     * @param customer Customer
     * @throws EntityNotFoundException The entity does not exist in database
     */
    private void checkEntitiesExist(Order order, Customer customer) throws EntityNotFoundException {
        if (order == null)
            throw new EntityNotFoundException(Order.class);
        if (customer == null)
            throw new EntityNotFoundException(Customer.class);
    }
}
