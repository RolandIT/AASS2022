package sk.fiit.services.impl;



import sk.fiit.controllers.DatabaseController;
import sk.fiit.models.Customer;
import sk.fiit.models.RegisterForm;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(endpointInterface = "services.CustomerService")
public class CustomerServiceImpl {

    @Inject
    private DatabaseController dbController;

    @WebMethod
    public long register(RegisterForm registerForm){
        return dbController.registerAccount(registerForm);
    }

    @WebMethod
    public ArrayList<Customer> getFilteredCustomers(String surname){
        return dbController.getFilteredCustomers(surname);
    }

}
