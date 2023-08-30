package com.microservice.gpstracker.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {

    List<VehicleModel> findAllVehicleByOwnerModelOwnerId(Long owner_id);

}
