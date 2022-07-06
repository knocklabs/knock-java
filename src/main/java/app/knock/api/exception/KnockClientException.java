package app.knock.api.exception;

public class KnockClientException extends RuntimeException {

    public KnockClientException(String message) {
        super(message);
    }

    public KnockClientException(String message, Exception e) {
        super(message, e);
    }

}
