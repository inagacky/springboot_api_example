package com.inagacky.api_sample_app.exception;


/**
 * データ不整合が発生した　場合の例外
 */
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
