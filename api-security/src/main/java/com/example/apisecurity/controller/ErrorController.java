package com.example.apisecurity.controller;

import com.example.apisecurity.exception.PasswordNotMatchError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({PasswordNotMatchError.class})
    public ResponseEntity habdleException(Throwable throwable) throws  Throwable{
        if(throwable instanceof PasswordNotMatchError){
            return ResponseEntity
                    .badRequest()
                    .body("Password did not match!");
        }
        return null;
    }
}
