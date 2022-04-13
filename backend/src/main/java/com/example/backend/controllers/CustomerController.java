package com.example.backend.controllers;

import com.example.backend.data_model.Customer;
import com.example.backend.helper.CustomerFilter;
import com.example.backend.helper.RegisterForm;
import com.example.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

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

    @PostMapping("customer/filter")
    public ArrayList<Customer> getFilteredCustomers(@RequestBody CustomerFilter customerFilter){
        ArrayList<Customer> customers = customerService.getFilteredCustomers(customerFilter.getSurname());
        if(customers.size() == 0){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No users with this surname: " + customerFilter.getSurname());
        }
        return customers;
    }
}
