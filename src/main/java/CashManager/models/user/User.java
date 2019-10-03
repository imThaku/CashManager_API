package CashManager.models.user;

import CashManager.models.adresse.Adresse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String Email;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Adresse adresse;
}


