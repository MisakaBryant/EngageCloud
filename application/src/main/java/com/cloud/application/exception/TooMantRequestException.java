package com.cloud.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS, reason = "Too Many Request")
public class TooMantRequestException extends RuntimeException {
    public TooMantRequestException(String message) {
        super(message);
    }
}
