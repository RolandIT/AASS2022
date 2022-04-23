package sk.fiit.services;


import sk.fiit.models.Repair;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface RepairsService {

    @WebMethod
    ArrayList<Repair> getCarsRepairs(long car_id);

    @WebMethod
    long insertCarRepair(Repair repair);
}
