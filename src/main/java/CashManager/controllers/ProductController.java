package CashManager.controllers;

import CashManager.dao.ProductRepository;
import CashManager.dto.product.ProductWraperDto;
import CashManager.models.order.Order;
import CashManager.models.product.Product;
import CashManager.models.product.ProductWraper;
import CashManager.models.user.Customer;
import CashManager.services.CustomerService;
import CashManager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/product")
    public List<Product> index(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product show(@PathVariable String id){
        int productId = Integer.parseInt(id);
        return this.productService.getProductById(productId);
    }

    @PostMapping("/product")
    public Product create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        return this.productService.addNewProduct(Product.builder().libelle(title).description(content).build());
    }

    @PostMapping("/product/{id}")
    public List<Product> addUserProduct(@PathVariable String id,@RequestBody ProductWraperDto body){
        Customer customer = customerService.getCustomerById(Integer.parseInt(id));
        List<Product> productList = customer.getCart();

        for (ProductWraper productInfo:body.getProducts()) {
            for (int i = 0; i < Integer.parseInt(productInfo.getQuantity()) ; i++) {
                Product product = this.productService.getProductById(Integer.parseInt(productInfo.getId()));
                productList.add(product);
            }
        }
        customer.setCart(productList);
        customerService.editCustomer(customer);

        return productList;
    }
}
