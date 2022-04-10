package com.example.backend.services;

import com.example.backend.BackendApplication;
import com.example.backend.data_model.Car;
import com.example.backend.helper.RegisterCar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    public ArrayList<Car> getUsersCarList(long id){
        return BackendApplication.dbController.getUsersCarList(id);
    }

    public ArrayList<Car> getCarsFiltered(String spz){
        return BackendApplication.dbController.getCarList(spz);
    }

    public long registerCar(RegisterCar car){
        Car newCar = new Car(-1, car.getSpz(), car.getYearOfManufacture(), car.getBrand(), car.getIdOwner());
        return BackendApplication.dbController.registerCar(newCar);
    }
}
