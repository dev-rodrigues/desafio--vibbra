package com.vibbra.user.datasources.feign.data;

public class QueyParamUserRequest {

    private String email;

    public QueyParamUserRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
