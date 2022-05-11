package app.knock.api.exception;

public class KnockClientJsonException extends RuntimeException {
    public KnockClientJsonException(String s, Exception e) {
        super(s, e);
    }
}
