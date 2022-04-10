package com.example.backend.controllers;

import com.example.backend.data_model.Car;
import com.example.backend.helper.RegisterCar;
import com.example.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("cars/{id}")
    public ArrayList<Car> getUsersCarList(@RequestParam(value = "id") long id){
        ArrayList<Car> listOfCars = carService.getUsersCarList(id);
        if(listOfCars == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cars found");
        return listOfCars;
    }
    @GetMapping("cars/{spz}")
    public ArrayList<Car> getCarsFiltered(@RequestParam(value = "spz", defaultValue = "") String spz){
        ArrayList<Car> listOfCars = carService.getCarsFiltered(spz);
        if(listOfCars == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cars found");
        return listOfCars;
    }
    @PostMapping("cars/register")
    public long registerCar(@RequestBody RegisterCar registerCar){
        long registeredId = carService.registerCar(registerCar);
        if(registeredId < 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't register this car " + registeredId);
        else return registeredId;
    }
}
