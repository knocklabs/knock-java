package app.knock.api.exception;

import app.knock.api.model.KnockErrorResponse;

import java.io.IOException;

public class KnockClientResourceException extends RuntimeException {

    public final KnockErrorResponse knockErrorResponse;

    public KnockClientResourceException(KnockErrorResponse knockErrorResponse) {
        super(knockErrorResponse.getCode());
        this.knockErrorResponse = knockErrorResponse;
    }

    public KnockClientResourceException(String s) {
        super(s);
        this.knockErrorResponse = null;
    }

    public KnockClientResourceException(String s, IOException e) {
        super(s, e);
        knockErrorResponse = null;
    }
}
