package CashManager.models.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductType {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int id;

    private String type;
}
