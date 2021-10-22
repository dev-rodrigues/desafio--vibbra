package com.vibbra.user.entities.response;

import com.vibbra.user.entities.User;

public class AuthenticationResponse {

    private String token;
    private User user;

    public AuthenticationResponse(String jwt, User user) {
        this.token = jwt;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
