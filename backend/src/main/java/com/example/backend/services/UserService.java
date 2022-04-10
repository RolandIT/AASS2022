package com.example.backend.services;

import com.example.backend.BackendApplication;
import com.example.backend.data_model.User;
import com.example.backend.helper.LoginBody;
import com.example.backend.helper.UserCustomer;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    public UserCustomer login(LoginBody loginBody) {
        return BackendApplication.dbController.login(loginBody.getUsername(), loginBody.getPassword());
    }

    public long register(User user){
        return BackendApplication.dbController.registerUser(user);
    }

}
