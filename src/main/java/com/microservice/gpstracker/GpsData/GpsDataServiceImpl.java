package com.microservice.gpstracker.GpsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpsDataServiceImpl implements GpsDataService{

    @Autowired
    private GpsDataRepository gpsDataRepository;

    @Override
    public List<GpsDataModel> findAllGpsDataByVehicleModelVehicleId(Long vehicleId) {
        return this.gpsDataRepository.findAllGpsDataByVehicleModelVehicleId(vehicleId);
    }

    @Override
    public GpsDataModel saveGpsDataModel(GpsDataModel gpsDataModel){
        return this.gpsDataRepository.save(gpsDataModel);
    }

}
