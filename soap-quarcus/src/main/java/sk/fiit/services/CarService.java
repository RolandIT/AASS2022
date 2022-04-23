package sk.fiit.services;


import sk.fiit.models.Car;
import sk.fiit.models.RegisterCar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface CarService {

    @WebMethod
    ArrayList<Car> getUsersCarList(@WebParam long id);

    @WebMethod
    ArrayList<Car> getCarsFiltered(@WebParam String spz);

    @WebMethod
    ArrayList<Car> getCars();

    @WebMethod
    long regCar(@WebParam RegisterCar car);
}
