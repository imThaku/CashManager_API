package CashManager.models.user;

import CashManager.models.adresse.Adresse;
import CashManager.models.order.Order;
import CashManager.models.payement.Payement;
import CashManager.models.product.Product;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Customer extends User {

    @ManyToMany
    private List<Payement> payements;

    @ManyToMany
    private List<Product> cart;

    @ManyToMany
    private List<Order> orders;

    @Builder
    public Customer(Integer id, String username, String password, String Email, String firstName, String lastName, Adresse adresse, List<Payement> payements, List<Product> cart, List<Order> orders) {
        super(id, username, password, Email, firstName, lastName, adresse);
        this.payements = payements;
        this.cart = cart;
        this.orders = orders;
    }
}
