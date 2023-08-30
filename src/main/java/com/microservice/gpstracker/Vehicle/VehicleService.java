package com.microservice.gpstracker.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    public List<VehicleModel> findAllVehicleByOwnerModelOwnerId(Long owner_id);
    public Optional<VehicleModel> getVehicleById(Long vehicle_id);
    public VehicleModel saveVehicle(VehicleModel vehicleModel);
    public String deleteAllVehicles();
    public String deleteVehicleById(Long vehicle_id);

}
