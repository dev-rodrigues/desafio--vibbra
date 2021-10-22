package com.vibbra.deal.entities;

import java.math.BigDecimal;

public class Deal {

    private BigDecimal id;
    private String typeOfDeal;
    private Double value;
    private String description;
    private String tradeFor;
    private Double lat;
    private Double lng;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;
    private String urgency;
    private String urgencyDate;
    private Long userId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTypeOfDeal() {
        return typeOfDeal;
    }

    public void setTypeOfDeal(String typeOfDeal) {
        this.typeOfDeal = typeOfDeal;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTradeFor() {
        return tradeFor;
    }

    public void setTradeFor(String tradeFor) {
        this.tradeFor = tradeFor;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getUrgencyDate() {
        return urgencyDate;
    }

    public void setUrgencyDate(String urgencyDate) {
        this.urgencyDate = urgencyDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
