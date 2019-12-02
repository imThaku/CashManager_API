package CashManager.models.user;

import CashManager.models.adresse.Adresse;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    private String role;

    @ManyToOne
    private Adresse adresse;
}


