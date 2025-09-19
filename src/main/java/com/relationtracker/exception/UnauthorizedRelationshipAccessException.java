package com.relationtracker.exception;

public class UnauthorizedRelationshipAccessException extends RuntimeException {
    public UnauthorizedRelationshipAccessException(String message) {
        super(message);
    }
}
