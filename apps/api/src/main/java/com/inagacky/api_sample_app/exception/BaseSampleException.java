package com.inagacky.api_sample_app.exception;

public abstract class BaseSampleException extends Exception {

    public BaseSampleException(String message) {
        super(message);
    }

    public BaseSampleException(Throwable cause) {
        super(cause);
    }

    public BaseSampleException(String message, Throwable cause) {
        super(message, cause);
    }
}
