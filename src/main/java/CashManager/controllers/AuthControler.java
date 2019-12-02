package CashManager.controllers;

import CashManager.models.user.Customer;
import CashManager.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControler {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer user) {
        Customer userData = customerService.getCustomerByUsername(user.getUsername());
        if (userData != null){
            if (userData.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>(userData,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
