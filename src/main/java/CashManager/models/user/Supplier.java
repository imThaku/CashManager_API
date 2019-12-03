package CashManager.models.user;


import CashManager.models.adresse.Adresse;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Supplier extends User {

    @Builder
    public Supplier(Integer id, String username, String password, String Email, String firstName, String lastName, Adresse adresse) {
        super(id, username, password, Email, firstName, lastName, adresse);
    }
}
