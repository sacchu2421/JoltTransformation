package com.example.integration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is an Exception Class which will extends Runtime exception (We extends runtime exception in case
 * where we have unchecked exceptions) so this class will act as an exception and will store all the exception
 * we got so whatever fields we want to map to our desired response we can populate here)
 */
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private String errorMessage;

    private int statusCode;
}
