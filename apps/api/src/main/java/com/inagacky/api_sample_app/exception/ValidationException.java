package com.inagacky.api_sample_app.exception;

/**
 * 入力値不正
 */
public class ValidationException extends BaseSampleException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
