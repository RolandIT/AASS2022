package sk.fiit.services.impl;



import sk.fiit.controllers.DatabaseController;
import sk.fiit.models.LoginBody;
import sk.fiit.models.User;
import sk.fiit.models.UserCustomer;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(endpointInterface = "services.UserService")
public class UserServiceImpl {

    @Inject
    private DatabaseController dbController;

    @WebMethod
    public UserCustomer login(LoginBody loginBody) {
        return dbController.login(loginBody.getUsername(), loginBody.getPassword());
    }

    @WebMethod
    public long register(User user){
        return dbController.registerUser(user);
    }
}
