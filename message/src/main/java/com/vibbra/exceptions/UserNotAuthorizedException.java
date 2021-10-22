package com.vibbra.exceptions;

public class UserNotAuthorizedException extends RuntimeException {
    private String message;

    public UserNotAuthorizedException(String message) {
        super(message);
        this.message = message;
    }
}
