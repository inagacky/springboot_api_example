package com.inagacky.api_sample_app.exception;

public class IllegalDataException extends BaseSampleException {

    public IllegalDataException(String message) {
        super(message);
    }

    public IllegalDataException(Throwable cause) {
        super(cause);
    }

    public IllegalDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
