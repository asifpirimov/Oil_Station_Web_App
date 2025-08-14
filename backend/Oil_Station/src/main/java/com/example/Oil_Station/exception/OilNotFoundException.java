package com.example.Oil_Station.exception;

public class OilNotFoundException extends RuntimeException{
    public OilNotFoundException(Long id) {
        super("Oil not found: " + id);
    }

}
