package CashManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when trying to create a product with a null or negative price
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Product price cannot be negative or null")
public class InvalidPriceException extends RuntimeException { }
