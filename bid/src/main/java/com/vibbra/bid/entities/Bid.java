package com.vibbra.bid.entities;

import java.math.BigDecimal;

public class Bid {

    private BigDecimal id;
    private BigDecimal idDeal;
    private Integer userId;
    private Boolean accepted;
    private Integer value;
    private String description;

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

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(BigDecimal idDeal) {
        this.idDeal = idDeal;
    }
}
