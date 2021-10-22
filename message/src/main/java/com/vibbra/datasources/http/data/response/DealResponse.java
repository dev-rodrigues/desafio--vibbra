package com.vibbra.datasources.http.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.List;

public class DealResponse {
    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("description")
    private String description;

    @JsonProperty("trade_for")
    private String tradeFor;

    @JsonProperty("location")
    private DealResponseLocation location;

    @JsonProperty("urgency")
    private DealResponseUrgency urgency;

    @JsonProperty("photos")
    @Valid
    private List<String> photos = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTradeFor() {
        return tradeFor;
    }

    public void setTradeFor(String tradeFor) {
        this.tradeFor = tradeFor;
    }

    public DealResponseLocation getLocation() {
        return location;
    }

    public void setLocation(DealResponseLocation location) {
        this.location = location;
    }

    public DealResponseUrgency getUrgency() {
        return urgency;
    }

    public void setUrgency(DealResponseUrgency urgency) {
        this.urgency = urgency;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
