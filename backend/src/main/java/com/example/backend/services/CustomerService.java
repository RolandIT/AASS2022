package com.example.backend.services;

import com.example.backend.BackendApplication;
import com.example.backend.helper.RegisterForm;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {

    public long register(RegisterForm registerForm){
        return BackendApplication.dbController.registerAccount(registerForm);
    }
}
