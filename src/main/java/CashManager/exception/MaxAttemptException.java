package CashManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a set number of payment attempt has been reached
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Maximum of payment attempt reached")
public class MaxAttemptException extends RuntimeException { }
