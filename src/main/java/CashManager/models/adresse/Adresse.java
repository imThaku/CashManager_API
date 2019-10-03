package CashManager.models.adresse;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;

    private Integer cityCode;

    @ManyToOne
    private AdresseType adresseType;

    private String libelle;

    private String libelleComp;
}
