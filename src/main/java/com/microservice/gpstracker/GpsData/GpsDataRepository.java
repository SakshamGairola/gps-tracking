package com.microservice.gpstracker.GpsData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpsDataRepository extends JpaRepository<GpsDataModel, Long> {

    List<GpsDataModel> findAllGpsDataByVehicleModelVehicleId(Long vehicleId);

}
