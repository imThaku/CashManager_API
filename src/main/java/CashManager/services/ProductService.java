package CashManager.services;

import CashManager.models.product.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Integer id);

    public Product addNewProduct(Product product);
}
