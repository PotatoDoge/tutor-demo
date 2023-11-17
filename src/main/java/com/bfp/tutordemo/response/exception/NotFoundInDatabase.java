package com.bfp.tutordemo.response.exception;

public class NotFoundInDatabase extends RuntimeException{

    public NotFoundInDatabase(String message){
        super(message);
    }
}
