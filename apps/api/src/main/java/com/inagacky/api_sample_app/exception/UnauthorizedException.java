package com.inagacky.api_sample_app.exception;

/**
 * 認可失敗時の例外　
 */
public class UnauthorizedException extends BaseSampleException {

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
