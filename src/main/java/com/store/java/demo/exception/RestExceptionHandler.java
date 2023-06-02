package com.store.java.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetail> handlerValidException(MethodArgumentNotValidException e) {
        HashMap<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(erro -> {
            String fieldName = ((FieldError) erro).getField();
            String messageError = erro.getDefaultMessage();
            errors.put(fieldName, messageError);
        });
        return new ResponseEntity<>(
                new ExceptionDetail(
                        "Bad Request! Consult the documentation",
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        e.getClass().toString(),
                        errors
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDetail> handlerValidException(IllegalArgumentException e) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put(e.getCause().toString(), e.getMessage());


        ExceptionDetail exceptionDetail = new ExceptionDetail(
                "Bad Request! Consult the documentation",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getClass().toString(),
                errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDetail);
    }
}