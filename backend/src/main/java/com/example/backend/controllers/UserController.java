package com.example.backend.controllers;

import com.example.backend.data_model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public User login(@RequestParam(value="username") String username,@RequestParam(value="password") String password){
        return new User(1, "Jano", "Lango", username, "");
    }
}
