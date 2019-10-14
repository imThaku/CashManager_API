package CashManager.models.order;

import CashManager.models.payement.Payement;
import CashManager.models.product.Product;
import CashManager.models.user.Supplier;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "UserOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double total;

    private Double poid;

    private Date payementDate;

    @ManyToOne
    private OrderStatus orderStatus;

    @ManyToOne
    private Payement payement;

    @ManyToOne
    private Supplier supplier;

    @ManyToMany
    private List<Product> products;

}
