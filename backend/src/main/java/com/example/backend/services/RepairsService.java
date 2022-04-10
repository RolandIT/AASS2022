package com.example.backend.services;

import com.example.backend.BackendApplication;
import com.example.backend.data_model.Repair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RepairsService {

    public ArrayList<Repair> getCarsRepairs(long car_id){
        return BackendApplication.dbController.getCarsRepairs(car_id);
    }
}
