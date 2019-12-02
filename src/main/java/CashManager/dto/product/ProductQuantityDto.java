package CashManager.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto for product dto and its quantity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuantityDto {

    private ProductDto product;

    private int quantity;

    /**
     * Get the id of the product
     * @return Id of the product
     */
    public int getId() { return product.getId(); }

    /**
     * Increase the quantity by one
     */
    public void addProduct() { quantity++; }

    public ProductQuantityDto(ProductDto product) {
        this.product = product;
        this.quantity = 1;
    }
}
