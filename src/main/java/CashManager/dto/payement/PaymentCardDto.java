package CashManager.dto.payement;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for tranmitting payment by card info
 */
@Getter
@Setter
public class PaymentCardDto {

    /**
     * Card id
     */
    private String cardId;

    /**
     * Id of the order to be payed
     */
    private int orderId;

    public PaymentCardDto() { }

    public PaymentCardDto(String cardId, int orderId) {
        this.cardId = cardId;
        this.orderId = orderId;
    }
}
