package com.microservice.gpstracker.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<OwnerModel> getAllOwners();

    Optional<OwnerModel> getOwnerById(Long owner_id);

    OwnerModel saveOwner(OwnerModel ownerModel);

    String deleteAllOwners();

    String deleteOwnerById(Long owner_id);

}
