package com.vibbra.exceptions;

public class MessageNotLocalizedException extends RuntimeException{
    private String message;

    public MessageNotLocalizedException(String message) {
        super(message);
        this.message = message;
    }
}