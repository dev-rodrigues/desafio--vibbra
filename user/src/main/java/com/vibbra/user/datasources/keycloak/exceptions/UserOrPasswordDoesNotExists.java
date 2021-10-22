package com.vibbra.user.datasources.keycloak.exceptions;

public class UserOrPasswordDoesNotExists extends RuntimeException {

    private final String msg;

    public UserOrPasswordDoesNotExists(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
