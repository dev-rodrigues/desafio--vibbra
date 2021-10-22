package com.vibbra.user.datasources.feign.data;

public class ResponseGetUserByEmail {

    UserRepresentation[] users;

    public UserRepresentation[] getUsers() {
        return users;
    }

    public void setUsers(UserRepresentation[] users) {
        this.users = users;
    }
}
