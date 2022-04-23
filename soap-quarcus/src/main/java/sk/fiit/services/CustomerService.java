package sk.fiit.services;


import sk.fiit.models.Customer;
import sk.fiit.models.RegisterForm;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface CustomerService {

    @WebMethod
    long register(RegisterForm registerForm);

    @WebMethod
    ArrayList<Customer> getFilteredCustomers(String surname);
}
