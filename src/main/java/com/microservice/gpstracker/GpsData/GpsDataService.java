package com.microservice.gpstracker.GpsData;

import java.sql.Date;
import java.util.List;

public interface GpsDataService {

    List<GpsDataModel> findAllGpsDataByVehicleModelVehicleId(Long vehicleId);

    GpsDataModel saveGpsDataModel(GpsDataModel gpsDataModel);

    List<GpsDataModel> getAllCoordinates(Long vehicleId, Date startDate, Date endDate);

}
