package CashManager.controllers;

import CashManager.dto.product.ProductDto;
import CashManager.dto.product.ProductWraperDto;
import CashManager.exception.InvalidPriceException;
import CashManager.models.product.Product;
import CashManager.models.product.ProductWraper;
import CashManager.models.user.Customer;
import CashManager.services.CustomerService;
import CashManager.services.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Product> productList = new ArrayList<Product>();

        if (customer.getCart() != null)
            productList = customer.getCart();
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

    /**
     * Add a product to the database
     * @param productDto Product to add
     * @return Created product
     */
    @ApiOperation(value = "Create a new product in the database")
    @PostMapping("/product/addProduct")
    public Product addProduct(@RequestBody ProductDto productDto){
        if (productDto.getPrix() <= 0d)
            throw new InvalidPriceException();

        Product product = Product
                .builder()
                .description(productDto.getDescription())
                .libelle(productDto.getLibelle())
                .prix(productDto.getPrix())
                .build();

        return this.productService.addNewProduct(product);
    }
}
