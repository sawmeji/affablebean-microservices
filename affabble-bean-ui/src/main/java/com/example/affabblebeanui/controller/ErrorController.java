package com.example.affabblebeanui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler({IllegalArgumentException.class})
    public String handleException(Throwable throwable, Model model) throws Exception{
        model.addAttribute("message", throwable.getMessage());
        model.addAttribute("statusCode", "404 Not Found!");

        return "error";
    }
}
