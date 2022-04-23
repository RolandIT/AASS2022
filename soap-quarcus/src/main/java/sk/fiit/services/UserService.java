package sk.fiit.services;


import sk.fiit.models.LoginBody;
import sk.fiit.models.User;
import sk.fiit.models.UserCustomer;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    UserCustomer login(LoginBody loginBody);

    @WebMethod
    Long register(User user);
}
