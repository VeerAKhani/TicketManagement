package com.demo.ticketManagement.ticketManagement.excecption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = DataNotfoundException.class)
    public ResponseEntity<Object> exception(DataNotfoundException exception) {
        return new ResponseEntity<>(exception.error + " not found ", HttpStatus.NOT_FOUND);
    }
}
