package com.microservice.gpstracker.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<VehicleModel> findAllVehicleByOwnerModelOwnerId(Long owner_id);

    Optional<VehicleModel> getVehicleById(Long vehicle_id);

    VehicleModel saveVehicle(VehicleModel vehicleModel);

    String deleteAllVehicles();

    String deleteVehicleById(Long vehicle_id);

}
