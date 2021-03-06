package CashManager.controllers;

import CashManager.dao.PayementRepository;
import CashManager.dto.adresse.AdresseDto;
import CashManager.dto.adresse.AdresseTypeDto;
import CashManager.models.order.Order;
import CashManager.models.order.OrderStatus;
import CashManager.models.payement.Payement;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import CashManager.models.user.Supplier;
import CashManager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private PayementService payementService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/Order")
    public List<Order> index() {
        return this.orderService.getAllOrder();
    }

    @GetMapping("/Order/{id}")
    public Order show(@PathVariable String id) {
        int orderId = Integer.parseInt(id);
        return this.orderService.getOrderById(orderId);
    }

    @PostMapping("/Order")
    public Order create(@RequestBody Map<String, String> body) {
        Double total = Double.parseDouble(body.get("total"));
        Double poid = Double.parseDouble(body.get("poid"));
        Date payementDate = Date.valueOf(body.get("payementDate"));
        OrderStatus orderStatus = this.orderStatusService.getOrderStatusById(Integer.parseInt(body.get("orderStatus")));
        Payement payement = this.payementService.getPayementById(Integer.parseInt(body.get("payement")));
        Supplier supplier = this.supplierService.getSupplierById(Integer.parseInt(body.get("supplier")));
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder().id(1).build());
        productList.add(Product.builder().id(2).build());
        return this.orderService.addNewOrder(Order.builder().total(total)
                .poid(poid)
                .payementDate(payementDate)
                .orderStatus(orderStatus)
                .payement(payement)
                .products(productList)
                .supplier(supplier)
                .build());
    }

    @PostMapping("/Order/{id}")
    public Order createUserOrder(@RequestBody Map<String, String> body, @PathVariable String id) {
        Double total = Double.parseDouble(body.get("total"));
        Double poid = Double.parseDouble(body.get("poid"));
        Date payementDate = Date.valueOf(body.get("payementDate"));
        OrderStatus orderStatus = this.orderStatusService.getOrderStatusById(Integer.parseInt(body.get("orderStatus")));
        Payement payement = this.payementService.getPayementById(Integer.parseInt(body.get("payement")));
        Supplier supplier = this.supplierService.getSupplierById(Integer.parseInt(body.get("supplier")));
//        List<Product> productList = new ArrayList<>();
//        productList.add(Product.builder().id(1).build());
//        productList.add(Product.builder().id(2).build());
        Order order = Order.builder().total(total)
                .poid(poid)
                .payementDate(payementDate)
                .orderStatus(orderStatus)
                .payement(payement)
                .supplier(supplier)
                .build();
        this.orderService.addNewOrder(order);

        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        List<Order> orderList = customer.getOrders();
        orderList.add(order);
        customer.setOrders(orderList);
        customerService.editCustomer(customer);

        return order;
    }

    @DeleteMapping("/Order/{id}")
    public void deleteAdresse(@PathVariable String id) {
        int orderId = Integer.parseInt(id);
        this.orderService.deleteOrder(orderId);
    }
}
