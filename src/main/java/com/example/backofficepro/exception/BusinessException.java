package com.example.backofficepro.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException{
    private String code;
}
