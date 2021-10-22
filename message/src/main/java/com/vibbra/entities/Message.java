package com.vibbra.entities;

import java.math.BigDecimal;

public class Message {
    private BigDecimal id;
    private Integer userId;
    private String title;
    private String message;
    private BigDecimal idDeal;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(BigDecimal idDeal) {
        this.idDeal = idDeal;
    }
}
