package com.example.integration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomException extends Exception {

    private String errorMessage;

    private int statusCode;
}
