package CashManager.dto.user;

import CashManager.dto.adresse.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class UserDto {

    private Integer id;

    private String username;

    private String password;

    private String Email;

    private String firstName;

    private String lastName;

    private AdresseDto adresseDto;
}


