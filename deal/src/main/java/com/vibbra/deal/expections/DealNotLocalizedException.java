package com.vibbra.deal.expections;

public class DealNotLocalizedException extends RuntimeException{
    private String message;

    public DealNotLocalizedException(String message) {
        super(message);
        this.message = message;
    }
}
