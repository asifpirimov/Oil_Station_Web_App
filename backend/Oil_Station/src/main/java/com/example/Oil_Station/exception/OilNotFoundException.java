package com.example.Oil_Station.exception;

public class OilNotFoundException extends Exception{
    public OilNotFoundException(Long id) {
        super("Oil not found: " + id);
    }

}
