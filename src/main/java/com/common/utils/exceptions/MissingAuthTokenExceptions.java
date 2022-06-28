package com.common.utils.exceptions;

public class MissingAuthTokenExceptions extends AuthenticationExceptions{
    public MissingAuthTokenExceptions() {
        super("There was no authorization token found on the request");
    }
}
