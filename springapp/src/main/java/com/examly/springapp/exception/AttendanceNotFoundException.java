package com.examly.springapp.exception;

public class AttendanceNotFoundException extends RuntimeException {

    public AttendanceNotFoundException(String message) {
        super(message);
    }
}
