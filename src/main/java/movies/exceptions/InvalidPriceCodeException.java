package movies.exceptions;

public class InvalidPriceCodeException extends IllegalArgumentException {
    public InvalidPriceCodeException(String errorMessage) {
        super(errorMessage);
    }
}
