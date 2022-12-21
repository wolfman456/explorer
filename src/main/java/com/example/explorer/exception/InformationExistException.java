package com.example.explorer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

// this class is created to deal with http exceptions
@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException {
    HttpStatus status;
    String message;
    LocalDateTime time;

    public InformationExistException(HttpStatus status, String message, LocalDateTime time) {
        this.status = status;
        this.message = message;
        this.time = time;
    }

    public InformationExistException(String message, HttpStatus status, String message1, LocalDateTime time) {
        super(message);
        this.status = status;
        this.message = message1;
        this.time = time;
    }

    public InformationExistException(String message, Throwable cause, HttpStatus status, String message1, LocalDateTime time) {
        super(message, cause);
        this.status = status;
        this.message = message1;
        this.time = time;
    }

    public InformationExistException(Throwable cause, HttpStatus status, String message, LocalDateTime time) {
        super(cause);
        this.status = status;
        this.message = message;
        this.time = time;
    }

    public InformationExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status, String message1, LocalDateTime time) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.message = message1;
        this.time = time;
    }
}
