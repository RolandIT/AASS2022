package com.example.backend.controllers;

import com.example.backend.data_model.Repair;
import com.example.backend.services.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RepairsController {
    @Autowired
    private RepairsService repairsService;

    @GetMapping("cars/{id}")
    public ArrayList<Repair> getCarsRepairs(@RequestParam(value = "id") long car_id){
        ArrayList<Repair> listOfRepairs = repairsService.getCarsRepairs(car_id);
        if(listOfRepairs == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No repairs found");
        return listOfRepairs;
    }
}
