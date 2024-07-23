package com.example.alten.exception;

public class productNoFoundException extends RuntimeException{
    public productNoFoundException(String message) {
        super(message);
    }
}
