package com.vibbra.bid.datasources.http.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DealResponseUrgency {

    @JsonProperty("type")
    private String type;

    @JsonProperty("limit_date")
    private String limitDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }
}
