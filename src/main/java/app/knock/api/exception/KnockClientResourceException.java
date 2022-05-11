package app.knock.api.exception;

import java.io.IOException;

public class KnockClientResourceException extends RuntimeException {

    public KnockClientResourceException(String s) {
        super(s);
    }
    public KnockClientResourceException(String s, IOException e) {
        super(s, e);
    }
}
