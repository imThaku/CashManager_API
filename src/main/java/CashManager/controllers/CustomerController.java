package CashManager.controllers;

import CashManager.models.adresse.Adresse;
import CashManager.models.order.OrderStatus;
import CashManager.models.payement.Payement;
import CashManager.models.product.Product;
import CashManager.models.user.Customer;
import CashManager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> index(){
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer show(@PathVariable String id){
        int customerID = Integer.parseInt(id);
        return this.customerService.getCustomerById(customerID);
    }

    @PostMapping("/customer")
    public Customer create(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String password = body.get("password");
        String Email = body.get("Email");
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        return this.customerService.addNewCustomer(Customer.builder()
                .username(username)
                .Email(Email)
                .firstName(firstName)
                .password(password)
                .lastName(lastName)
                .build());
    }
}
