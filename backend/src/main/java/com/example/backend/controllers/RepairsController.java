package com.example.backend.controllers;

import com.example.backend.data_model.Repair;
import com.example.backend.helper.RepairBody;
import com.example.backend.services.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RepairsController {
    @Autowired
    private RepairsService repairsService;

    @GetMapping("repairs/{id}")
    public ArrayList<Repair> getCarsRepairs(@PathVariable(value = "id") long car_id){
        ArrayList<Repair> listOfRepairs = repairsService.getCarsRepairs(car_id);
        if(listOfRepairs == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No repairs found");
        return listOfRepairs;
    }
    @PostMapping("repairs")
    public long insertCarRepair(@RequestBody RepairBody repair){
        long newId = repairsService.insertCarRepair(new Repair(-1, repair.getDescription(),
                repair.getState(), repair.getCost(), repair.getIdCar()));
        if(newId == -1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to insert repair");
        return newId;
    }

}
