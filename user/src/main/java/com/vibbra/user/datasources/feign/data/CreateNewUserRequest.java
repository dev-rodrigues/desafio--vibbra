package com.vibbra.user.datasources.feign.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewUserRequest {

    private String id;
    private String username;
    private String firstName;
    private String email;
    private boolean enabled;
    private Map<String, Object> attributes;
    private List<Credentials> credentials;

    public CreateNewUserRequest(String id, String username, String firstName, String email, List<Credentials> credentials, Map<String, Object> attributes) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.email = email;
        this.enabled = true;
        this.credentials = credentials;
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCredentials(List<Credentials> credentials) {
        this.credentials = credentials;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
