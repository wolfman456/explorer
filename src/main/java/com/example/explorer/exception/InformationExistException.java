package com.example.explorer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// this class is created to deal with http exceptions
@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException {
    public InformationExistException(String message) {
        super(message);
    }
}
