package com.example.apisecurity.controller;

import com.example.apisecurity.data.User;
import com.example.apisecurity.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello!";
    }

    record RegisterRequest(@JsonProperty("first_name") String firstName,
                           @JsonProperty("last_name") String lastName,
                           String email,
                           String password,
                           @JsonProperty("confirm_password") String confirmPassword){

    }

    record RegisterResponse(Long id,
                            @JsonProperty("first_name") String firstName,
                            @JsonProperty("last_name") String lastName,
                            String email){

    }
/*
* curl -X POST -H "Content-Type : application/json" -d '{"first_name":"john", "last_name":"william", "email":"william", "password":"john", "confirm_password":"john"}' http://localhost:8070/security/register
* */
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        User user = userService.register(
                request.firstName,
                request.lastName,
                request.email,
                request.password,
                request.confirmPassword
        );

        return new RegisterResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

}
