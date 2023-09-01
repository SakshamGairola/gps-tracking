package com.microservice.gpstracker.GpsData;

import com.microservice.gpstracker.Vehicle.VehicleService;
import com.microservice.gpstracker.util.AuthorizeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/gpsData/{owner_id}")
public class GpsDataController {

    @Autowired
    private GpsDataService gpsDataService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AuthorizeUtility utility;

    @GetMapping("/getInfo/{vehicle_id}")
    public ResponseEntity<Object> findAllGpsDataByVehicleModelVehicleId(@PathVariable("owner_id") Long owner_id,
                                                                        @PathVariable("vehicle_id") Long vehicle_id) {
        if (utility.checkIfValid(owner_id, vehicle_id)) {
            List<GpsDataModel> vehicleGpsData = this.gpsDataService.findAllGpsDataByVehicleModelVehicleId(vehicle_id);
            return new ResponseEntity<>(vehicleGpsData, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorised", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/save/{vehicle_id}")
    public GpsDataModel saveVehicleCoordinates(@PathVariable("vehicle_id") Long vehicle_id,
                                               @RequestBody GpsDataModel gpsDataModel) {
        System.out.println(gpsDataModel);
        return this.vehicleService.getVehicleById(vehicle_id).map(vehicle -> {
            gpsDataModel.setVehicleModel(vehicle);
            return gpsDataService.saveGpsDataModel(gpsDataModel);
        }).get();

    }

    @GetMapping("/getDist/{vehicle_id}")
    public ResponseEntity<Object> getDistanceTravelled(@PathVariable("owner_id") Long owner_id, @PathVariable(
            "vehicle_id") Long vehicle_id, @RequestParam("startDate") String startDate,
                                                       @RequestParam("endDate") String endDate) {
        if (utility.checkIfValid(owner_id, vehicle_id)) {
            Double distance = calculateDistance(this.gpsDataService.getAllCoordinates(vehicle_id,
                    Date.valueOf(startDate), Date.valueOf(endDate)));
            return new ResponseEntity<>(distance, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorised", HttpStatus.UNAUTHORIZED);
    }

    private Double calculateDistance(List<GpsDataModel> coordinateList) {
        if (coordinateList.size() < 2) return 0D;

        double totalDistance = 0D;

        double earthRadiusKM = 6371;

        for (int i = 0; i < coordinateList.size() - 1; i++) {

            double longitude1 = Math.toRadians(coordinateList.get(i).getLongitude()), latitude1 =
                    Math.toRadians(coordinateList.get(i).getLatitude());

            double longitude2 = Math.toRadians(coordinateList.get(i + 1).getLongitude()), latitude2 =
                    Math.toRadians(coordinateList.get(i + 1).getLatitude());

            double diffLongitude = (longitude2 - longitude1), diffLatitude = (latitude2 - latitude1);

            double a =
                    Math.pow(Math.sin(diffLatitude / 2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(diffLongitude / 2), 2);

            double c = 2 * Math.asin(Math.sqrt(a));

            totalDistance += c * earthRadiusKM;
        }

        return totalDistance;
    }

}
