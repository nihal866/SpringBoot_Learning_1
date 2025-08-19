package com.nihal.restDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException ex) {
        ErrorResponse err = new ErrorResponse();

        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        err.setStatusCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // hanndling generic exceptions
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse err = new ErrorResponse();

        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        err.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
