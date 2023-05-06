package com.example.explorer.utility.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

// this is created to handle http connections
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException {

    private HttpStatus status;
    private String message;
    private LocalDateTime time;

    public InformationNotFoundException(HttpStatus status, String message, LocalDateTime time) {
        this.status = status;
        this.message = message;
        this.time = time;
    }
}