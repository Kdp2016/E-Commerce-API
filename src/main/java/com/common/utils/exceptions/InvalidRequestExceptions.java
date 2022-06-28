package com.common.utils.exceptions;

public class InvalidRequestExceptions extends RuntimeException {
    public InvalidRequestExceptions(String message) {
        super(message);
    }

    public InvalidRequestExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
