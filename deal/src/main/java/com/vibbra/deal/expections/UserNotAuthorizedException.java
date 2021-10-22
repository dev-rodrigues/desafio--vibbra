package com.vibbra.deal.expections;

public class UserNotAuthorizedException extends RuntimeException {
    private String message;

    public UserNotAuthorizedException(String message) {
        super(message);
        this.message = message;
    }
}
