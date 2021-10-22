package com.vibbra.bid.exceptions;

public class BidNotLocalizedException extends RuntimeException{
    private String message;

    public BidNotLocalizedException(String message) {
        super(message);
        this.message = message;
    }
}
