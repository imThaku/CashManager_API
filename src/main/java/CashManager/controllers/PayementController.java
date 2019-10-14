package CashManager.controllers;

import CashManager.models.payement.Payement;
import CashManager.models.payement.PayementInfo;
import CashManager.models.payement.PayementType;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import CashManager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
