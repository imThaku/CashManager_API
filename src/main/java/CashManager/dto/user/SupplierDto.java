package CashManager.dto.user;


import CashManager.dto.adresse.AdresseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto extends UserDto {

    @Builder
    public SupplierDto(Integer id, String username, String password, String Email, String firstName, String lastName, AdresseDto adresseDto) {
        super(id, username, password, Email, firstName, lastName, adresseDto);
    }
}
