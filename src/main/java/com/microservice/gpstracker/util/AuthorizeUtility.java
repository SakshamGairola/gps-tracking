package com.microservice.gpstracker.util;

import com.microservice.gpstracker.Vehicle.VehicleModel;
import com.microservice.gpstracker.Vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Service
public class AuthorizeUtility {

    @Autowired
    private VehicleService vehicleService;


    public boolean checkIfValid(Long owner_id, Long vehicle_id){
        VehicleModel vehicle = vehicleService.getVehicleById(vehicle_id).get();
        return vehicle.getOwnerModel().getOwnerId().equals(owner_id);
    }

    public boolean checkIfValid(Long owner_id, VehicleModel vehicle){
        return vehicle.getOwnerModel().getOwnerId().equals(owner_id);
    }

}
