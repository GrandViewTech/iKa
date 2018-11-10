package com.gvt.ika.app.entity.exception;

public class InvalidToken extends  Exception {

    public InvalidToken() {
        super();
    }

    public InvalidToken(String message) {
        super(message);
    }

    public InvalidToken(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidToken(Throwable cause) {
        super(cause);
    }

    protected InvalidToken(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
