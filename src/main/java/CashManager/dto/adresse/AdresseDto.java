package CashManager.dto.adresse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdresseDto {

    private String city;

    private Integer cityCode;

    private AdresseTypeDto adresseTypeDto;

    private String libelle;

    private String libelleComp;
}
