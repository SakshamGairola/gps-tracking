package com.microservice.gpstracker.Vehicle;

import com.microservice.gpstracker.Owner.OwnerService;
import com.microservice.gpstracker.util.AuthorizeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@RestController
@RequestMapping("/vehicle/{owner_id}")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private AuthorizeUtility utility;

    @GetMapping("/all-vehicles")
    public List<VehicleModel> getAllVehiclesByOwnerID(@PathVariable("owner_id") Long owner_id) {
        return this.vehicleService.findAllVehicleByOwnerModelOwnerId(owner_id);
    }

    @GetMapping("/get/{vehicle_id}")
    public ResponseEntity<Object> getVehicleById(@PathVariable("vehicle_id") Long owner_id,
                                                 @PathVariable("vehicle_id") Long vehicle_id) {
        VehicleModel vehicle = this.vehicleService.getVehicleById(vehicle_id).get();
        if (utility.checkIfValid(owner_id, vehicle))
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        return new ResponseEntity<>("Unauthorised", HttpStatus.UNAUTHORIZED);
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

    @DeleteMapping("/delete/{vehicle_id}")
    public ResponseEntity<Object> deleteVehicleById(@PathVariable("owner_id") Long owner_id,
                                                    @PathVariable("vehicle_id") Long vehicle_id) {
        VehicleModel vehicle = this.vehicleService.getVehicleById(vehicle_id).get();
        if (utility.checkIfValid(owner_id, vehicle)) {
            this.vehicleService.deleteVehicleById(vehicle_id);
            return new ResponseEntity<>("Deleted \n" + vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorised", HttpStatus.UNAUTHORIZED);

    }

}
