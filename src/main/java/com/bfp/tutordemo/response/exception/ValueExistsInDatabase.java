package com.bfp.tutordemo.response.exception;

public class ValueExistsInDatabase extends RuntimeException{
    String message;
    public ValueExistsInDatabase(String message){
        super(message);
    }
}
