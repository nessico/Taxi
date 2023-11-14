package com.solvd.taxi.exceptions;

public class InvalidRideTypeException extends RuntimeException {
    public InvalidRideTypeException(String message) {
        super(message);
    }
}
