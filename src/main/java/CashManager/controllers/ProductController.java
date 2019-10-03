package CashManager.controllers;

import CashManager.dao.ProductRepository;
import CashManager.models.product.Product;
import CashManager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

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
}
