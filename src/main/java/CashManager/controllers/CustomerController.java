package CashManager.controllers;

import CashManager.dto.product.ProductDto;
import CashManager.dto.product.ProductQuantityDto;
import CashManager.dto.product.ProductWraperDto;
import CashManager.exception.EntityNotFoundException;
import CashManager.models.adresse.Adresse;
import CashManager.models.order.OrderStatus;
import CashManager.models.payement.Payement;
import CashManager.models.product.Product;
import CashManager.models.product.ProductWraper;
import CashManager.models.user.Customer;
import CashManager.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

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

    /**
     * Return the previous cart of the given customer.
     * @param id customer id
     * @return List of product with quantity
     */
    @GetMapping("/customer/{id}/cart")
    public List<ProductQuantityDto> getCart(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        List<ProductQuantityDto> cart = new ArrayList<>();
        boolean itemAdded = false;

        if (customer == null)
            throw new EntityNotFoundException(Customer.class);

        for (Product product : customer.getCart()) {
            for (ProductQuantityDto item : cart) {
                if (product.getId() == item.getId()) {
                    item.addProduct();
                    itemAdded = true;
                    break;
                }
            }
            if (!itemAdded)
                cart.add(new ProductQuantityDto(new ProductDto(product)));
            itemAdded = false;
        }

        return cart;
    }

    /**
     * Set the cart of the given customer
     * @param id Id of the customer
     * @param body List of product with their quantity in the cart
     */
    @PostMapping("/customer/{id}/cart")
    public ResponseEntity setCart(@PathVariable String id, @RequestBody ProductWraperDto body){
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));

        if (customer == null)
            throw new EntityNotFoundException(Customer.class);

        List<Product> productList = new ArrayList<>();

        for (ProductWraper productInfo : body.getProducts()) {
            Product product = this.productService.getProductById(Integer.parseInt(productInfo.getId()));
            for (int i = 0; i < Integer.parseInt(productInfo.getQuantity()) ; i++) {
                productList.add(product);
            }
        }

        customer.setCart(productList);
        customerService.editCustomer(customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Reset the given customer's cart
     * @param id Id of the customer
     * @return 200 if success, 404 if customer not found
     */
    @DeleteMapping("/customer/{id}/cart")
    public ResponseEntity resetCart(@PathVariable String id){
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));

        if (customer == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        List<Product> productList = new ArrayList<>();

        customerService.clearCart(customer);

        return new ResponseEntity(HttpStatus.OK);
    }
}
