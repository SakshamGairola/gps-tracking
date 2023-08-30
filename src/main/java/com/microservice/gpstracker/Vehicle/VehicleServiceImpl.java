package com.microservice.gpstracker.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleModel> findAllVehicleByOwnerModelOwnerId(Long owner_id) {
        return this.vehicleRepository.findAllVehicleByOwnerModelOwnerId(owner_id);
    }

    @Override
    public Optional<VehicleModel> getVehicleById(Long vehicle_id) {
        return this.vehicleRepository.findById(vehicle_id);
    }

    @Override
    public VehicleModel saveVehicle(VehicleModel vehicleModel) {
        return this.vehicleRepository.save(vehicleModel);
    }

    @Override
    public String deleteAllVehicles() {
        this.vehicleRepository.deleteAll();
        return "All Vehicles deleted";
    }

    @Override
    public String deleteVehicleById(Long vehicle_id) {
        this.vehicleRepository.deleteById(vehicle_id);
        return "Vehicle deleted";
    }
}
