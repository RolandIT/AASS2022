package com.example.backend.controllers;

import com.example.backend.helper.RegisterForm;
import com.example.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("customer/register")
    public long registerCustomer(@RequestBody RegisterForm registerForm) {
        long registeredId = customerService.register(registerForm);
        if(registeredId < 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Some pizdec occured " + registeredId);
        }
        return registeredId;
    }
}
