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
@Getter
@Setter
public class Customer extends User {

    @ManyToOne
    private Payement payement;

    @ManyToMany
    private List<Product> cart;

    @ManyToOne
    private Order order;

    @Builder
    public Customer(Integer id, String username, String password, String Email, String firstName, String lastName, Adresse adresse, Payement payement, List<Product> cart, Order order) {
        super(id, username, password, Email, firstName, lastName, adresse);
        this.payement = payement;
        this.cart = cart;
        this.order = order;
    }
}
