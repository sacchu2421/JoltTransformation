package com.example.integration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private final int statusCode;
    private final String errorMessage;

}
