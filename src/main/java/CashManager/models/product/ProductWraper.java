package CashManager.models.product;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductWraper {
    String id;
    String quantity;
}
