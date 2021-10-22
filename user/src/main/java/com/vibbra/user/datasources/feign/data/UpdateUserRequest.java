package com.vibbra.user.datasources.feign.data;

import java.util.List;

public class UpdateUserRequest {

    private String username;
    private String firstName;
    private String email;
    private List<Credentials> credentials;

    public UpdateUserRequest(String username, String firstName, String email, List<Credentials> credentials) {
        this.username = username;
        this.firstName = firstName;
        this.email = email;
        this.credentials = credentials;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }
}
