package com.common.utils.exceptions;

public class TokenParseExceptions extends AuthenticationExceptions{
    public TokenParseExceptions(Throwable cause) {
        super("The provided token could not be parsed", cause);
    }

    public TokenParseExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
