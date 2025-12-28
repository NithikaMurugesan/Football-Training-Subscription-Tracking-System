package com.examly.springapp.exception;


public class MembershipTypeNotFoundException extends RuntimeException {

    public MembershipTypeNotFoundException(String message) {
        super(message);
    }
}
