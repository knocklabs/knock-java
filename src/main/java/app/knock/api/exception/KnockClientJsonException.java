package app.knock.api.exception;

public class KnockClientJsonException extends KnockClientException {
    public KnockClientJsonException(String s, Exception e) {
        super(s, e);
    }
}
