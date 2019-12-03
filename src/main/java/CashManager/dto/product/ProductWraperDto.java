package CashManager.dto.product;

import CashManager.models.product.ProductWraper;
import lombok.*;

import java.util.List;


@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductWraperDto {
    List<ProductWraper> products;
}
