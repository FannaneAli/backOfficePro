package com.example.backofficepro.controller;


//import com.example.backofficepro.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {
//
//    public GenericControllerAdvice() {
//
//    }
//    @ExceptionHandler(BusinessException.class)
//    public ResponseEntity<String> handleBusinessException(BusinessException e) {
//
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(e.getCode()));
//    }
}
