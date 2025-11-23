package com.example.DoctorDesk.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String ex) {
        super(ex);
    }
}
