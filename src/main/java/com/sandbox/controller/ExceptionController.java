package com.sandbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.error("An error occurred: {}", e.getMessage(), e);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ErrorResponse(INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Illegal argument: {}", e.getMessage(), e);
        return ResponseEntity.badRequest().body(new ErrorResponse(BAD_REQUEST.value(), "Illegal argument: " + e.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity handleIllegalStateException(IllegalStateException e) {
        log.error("Illegal state: {}", e.getMessage(), e);
        return ResponseEntity.status(CONFLICT).body(new ErrorResponse(CONFLICT.value(), "Illegal state: " + e.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleResourceNotFoundException(NoSuchElementException e) {
        log.error("Resource not found: {}", e.getMessage(), e);
        return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(NOT_FOUND.value(), "Resource not found"));
    }
}
