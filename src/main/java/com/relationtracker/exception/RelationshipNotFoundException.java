package com.relationtracker.exception;

public class RelationshipNotFoundException extends RuntimeException {
    public RelationshipNotFoundException(String message) {
        super(message);  // This passes the message to the parent Exception class
    }
}
