package com.emmang.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> notAuthenticatedExceptionHandling(UsernameNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}