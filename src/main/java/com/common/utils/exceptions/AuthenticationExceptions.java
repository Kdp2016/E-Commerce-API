package com.common.utils.exceptions;

public class AuthenticationExceptions extends RuntimeException{
    public AuthenticationExceptions() {
        super("No user record found using the provided credentials!");
    }

    public AuthenticationExceptions(String message) {
        super(message);
    }

    public AuthenticationExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
