package com.microservice.gpstracker.GpsData;

import com.microservice.gpstracker.Vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gpsData/{owner_id}/{vehicle_id}")
public class GpsDataController {

    @Autowired
    private GpsDataService gpsDataService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getInfo")
    public List<GpsDataModel> findAllGpsDataByVehicleModelVehicleId(Long vehicleId) {
        List<GpsDataModel> test = this.gpsDataService.findAllGpsDataByVehicleModelVehicleId(1L);
        System.out.println(test);
        return test;
    }

    @PostMapping("/save")
    public String saveVehicleCoordinates(@PathVariable("vehicle_id") Long vehicle_id,
                                         @RequestBody GpsDataModel gpsDataModel) {
        this.vehicleService.getVehicleById(vehicle_id).map(vehicle -> {
            gpsDataModel.setVehicleModel(vehicle);
            return gpsDataService.saveGpsDataModel(gpsDataModel);
        }).get();

        return null;
    }

}
