package com.example.apisecurity.service;

import com.example.apisecurity.data.User;
import com.example.apisecurity.data.UserDao;
import com.example.apisecurity.exception.PasswordNotMatchError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(String firstName,
                         String lastName,
                         String email,
                         String password,
                         String confirmPassword){
        if(!passwordEncoder.matches(password,confirmPassword)){
            throw new PasswordNotMatchError();
        }


        return userDao.save(
                User.of(
                        firstName,
                        lastName,
                        email,
                        passwordEncoder.encode(password)
                )
        );
    }
}
