package com.example.integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMyCustomException(CustomException ex) {
        ErrorResponse response = new ErrorResponse(ex.getStatusCode(), ex.getErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //TODO Need to find a way to eliminate ErrorResponse class as there are multiple classes we have as of now
    // Add more exception handlers for other exceptions if needed
}
