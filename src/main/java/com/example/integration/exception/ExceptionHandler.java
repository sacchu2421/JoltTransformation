package com.example.integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomException> handleMyCustomException(CustomException ex) {
        CustomException response = new CustomException(ex.getErrorMessage(), ex.getStatusCode());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Add more exception handlers for other exceptions if needed
}
