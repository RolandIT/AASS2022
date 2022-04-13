package com.example.backend.services;

import com.example.backend.BackendApplication;
import com.example.backend.data_model.Customer;
import com.example.backend.helper.RegisterForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {

    public long register(RegisterForm registerForm){
        return BackendApplication.dbController.registerAccount(registerForm);
    }
    public ArrayList<Customer> getFilteredCustomers(String surname){
        return BackendApplication.dbController.getFilteredCustomers(surname);
    }
}
