package ass5.exceptions;

public class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
