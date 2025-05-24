package com.example.vehicle.exception;

public class DuplicatePlateNumberException extends RuntimeException {
    public DuplicatePlateNumberException(String message) {
        super(message);
    }
}