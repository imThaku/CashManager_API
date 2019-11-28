package CashManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when cheque value do not match order total
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Invalid cheque value")
public class InvalidChequeValueException extends RuntimeException {
}
