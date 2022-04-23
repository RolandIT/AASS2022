package sk.fiit.services.impl;



import sk.fiit.controllers.DatabaseController;
import sk.fiit.models.Repair;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(endpointInterface = "services.RepairService")
public class RepairServiceImpl {

    @Inject
    private DatabaseController dbController;

    @WebMethod
    public ArrayList<Repair> getCarsRepairs(long car_id){
        return dbController.getCarsRepairs(car_id);
    }

    @WebMethod
    public long insertCarRepair(Repair repair){
        return dbController.insertCarRepair(repair);
    }
}
