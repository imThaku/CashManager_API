package CashManager.services;

import CashManager.dao.ProductRepository;
import CashManager.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return this.productRepository.findOne(id);
    }

    public Product addNewProduct(Product product) {
        return this.productRepository.save(product);
    }
}
