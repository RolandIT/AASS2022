package com.example.backend.controllers;

import com.example.backend.BackendApplication;
import com.example.backend.data_model.User;
import com.example.backend.helper.LoginBody;
import com.example.backend.helper.RegisterUser;
import com.example.backend.helper.UserCustomer;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user/login")
    public UserCustomer login(@RequestBody LoginBody loginBody){
        UserCustomer loggedIn = userService.login(loginBody);
        if(loggedIn == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username or password is incorrect");
        return loggedIn;
    }

    @PostMapping("user/register")
    public long createUser(@RequestBody RegisterUser user){
        long returnValue = userService.register(new User(user.getUsername(), user.getPassword(), user.getType()));
        if(returnValue == 0){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        else if(returnValue < 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Some other pizdec occured");
        }
        return returnValue;
    }
}
