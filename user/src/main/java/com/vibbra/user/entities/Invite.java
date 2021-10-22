package com.vibbra.user.entities;

public class Invite {

    private Long id;

    private String name;

    private String email;

    private Integer user;

    private Integer userInvited;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getUserInvited() {
        return userInvited;
    }

    public void setUserInvited(Integer userInvited) {
        this.userInvited = userInvited;
    }
}
