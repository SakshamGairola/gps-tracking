package com.microservice.gpstracker.GpsData;

import java.util.List;

public interface GpsDataService {

    List<GpsDataModel> findAllGpsDataByVehicleModelVehicleId(Long vehicleId);

    GpsDataModel saveGpsDataModel(GpsDataModel gpsDataModel);

}
