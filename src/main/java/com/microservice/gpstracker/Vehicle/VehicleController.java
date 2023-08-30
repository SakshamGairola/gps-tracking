package com.microservice.gpstracker.Vehicle;

import com.microservice.gpstracker.Owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/{owner_id}")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all-vehicles")
    public List<VehicleModel> getAllVehiclesByOwnerID(@PathVariable("owner_id") Long owner_id) {
        return this.vehicleService.findAllVehicleByOwnerModelOwnerId(owner_id);
    }

    @GetMapping("/get-vehicle/{vehicle_id}")
    public VehicleModel getVehicleById(@PathVariable("vehicle_id") Long vehicle_id) {
        return this.vehicleService.getVehicleById(vehicle_id).get();
    }

    @PostMapping("/save")
    public VehicleModel saveVehicle(@PathVariable("owner_id") Long owner_id, @RequestBody VehicleModel vehicleModel) {
        return this.ownerService.getOwnerById(owner_id).map(owner -> {
            vehicleModel.setOwnerModel(owner);
            return vehicleService.saveVehicle(vehicleModel);
        }).get();
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllVehicles() {
        return this.vehicleService.deleteAllVehicles();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVehicleById(@PathVariable("id") Long vehicle_id) {
        return this.vehicleService.deleteVehicleById(vehicle_id);
    }

}
