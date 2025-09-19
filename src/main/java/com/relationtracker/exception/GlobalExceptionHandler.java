package com.relationtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // This makes it work for ALL controllers
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RelationshipNotFoundException.class)
    public ResponseEntity<String> handleRelationshipNotFound(RelationshipNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
    @ExceptionHandler(UnauthorizedRelationshipAccessException.class)
    public ResponseEntity<String> handleUnauthorizedAccess(UnauthorizedRelationshipAccessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    // Handle any other unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An unexpected error occurred: " + ex.getMessage());
    }
}
