package com.inagacky.api_sample_app.exception;

public class SampleSQLException extends BaseSampleException {

    public SampleSQLException(String message) {
        super(message);
    }

    public SampleSQLException(Throwable cause) {
        super(cause);
    }

    public SampleSQLException(String message, Throwable cause) {
        super(message, cause);
    }
}
