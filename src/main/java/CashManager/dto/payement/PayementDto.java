package CashManager.dto.payement;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PayementDto {

    private Integer id;

    private PayementTypeDto payementTypeDto;

    private PayementInfoDto payementInfoDto;
}
