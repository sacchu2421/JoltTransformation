package com.example.integration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private String errorMessage;

    private int statusCode;
}
