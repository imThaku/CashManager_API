package CashManager.dto.payement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentChequeDto {

    /**
     * Cheque id
     */
    private String id;

    /**
     * Cheque value
     */
    private double chequeValue;

    /**
     * Id of the order to be payed
     */
    private int orderId;

    public PaymentChequeDto() { }

    public PaymentChequeDto(String id, double chequeValue, int orderId) {
        this.id = id;
        this.chequeValue = chequeValue;
        this.orderId = orderId;
    }
}
