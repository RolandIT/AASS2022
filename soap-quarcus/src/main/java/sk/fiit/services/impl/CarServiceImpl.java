package sk.fiit.services.impl;



import sk.fiit.controllers.DatabaseController;
import sk.fiit.models.Car;
import sk.fiit.models.RegisterCar;
import sk.fiit.services.CarService;

import javax.inject.Inject;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(endpointInterface = "sk.fiit.services.CarService")
public class CarServiceImpl implements CarService {

    @Inject
    private DatabaseController dbController;

    @WebMethod
    public ArrayList<Car> getUsersCarList(long id) {
        return dbController.getUsersCarList(id);
    }

    @WebMethod
    public ArrayList<Car> getCarsFiltered(String spz) {
        return dbController.getCarList(spz);
    }

    @WebMethod
    public ArrayList<Car> getCars(){
        return dbController.getCars();
    }

    @WebMethod
    public long regCar(RegisterCar car) {
        Car newCar = new Car(-1, car.getSpz(), car.getYearOfManufacture(), car.getBrand(), car.getIdOwner());
        return dbController.registerCar(newCar);
    }
}
