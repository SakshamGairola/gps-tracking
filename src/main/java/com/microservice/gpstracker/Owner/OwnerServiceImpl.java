package com.microservice.gpstracker.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    public List<OwnerModel> getAllOwners() {
        return this.ownerRepository.findAll();
    }

    @Override
    public Optional<OwnerModel> getOwnerById(Long owner_id) {
        return this.ownerRepository.findById(owner_id);
    }

    @Override
    public OwnerModel saveOwner(OwnerModel ownerModel) {
        return this.ownerRepository.save(ownerModel);
    }

    @Override
    public String deleteAllOwners() {
        this.ownerRepository.deleteAll();
        return "All Owners deleted";
    }

    @Override
    public String deleteOwnerById(Long owner_id) {
        this.ownerRepository.deleteById(owner_id);
        return "Owner deleted";
    }
}
