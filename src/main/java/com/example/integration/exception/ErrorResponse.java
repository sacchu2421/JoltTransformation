package com.example.integration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This is a model class which will get whatever fields we want from the Custom exception
 * in order to move it for further usage
 *
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private final int statusCode;
    private final String errorMessage;

}
