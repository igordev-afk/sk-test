package com.wwerlosh.skexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAnyException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(new ErrorResponse(ex.getMessage()));
    }

    public record ErrorResponse(String message) { }
}
