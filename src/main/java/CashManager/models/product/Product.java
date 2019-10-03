package CashManager.models.product;


import CashManager.models.user.Supplier;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String libelle;

    private String description;

    private Double prix;

    private Double poid;

    @ManyToOne
    private ProductType productType;

    @ManyToOne
    private Supplier supplier;
}
