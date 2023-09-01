package com.microservice.gpstracker.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all-owners")
    public List<OwnerModel> getAllOwners() {
        return this.ownerService.getAllOwners();
    }

    @GetMapping("/get-owner/{owner_id}")
    public OwnerModel getOwnerById(@PathVariable("owner_id") Long owner_id) {
        return this.ownerService.getOwnerById(owner_id).get();
    }

    @PostMapping("/save")
    public OwnerModel saveOwner(@RequestBody OwnerModel ownerModel) {
        return this.ownerService.saveOwner(ownerModel);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllOwners() {
        return this.ownerService.deleteAllOwners();
    }

    @DeleteMapping("/delete/{owner_id}")
    public String deleteOwnerById(@PathVariable("owner_id") Long owner_id) {
        return this.ownerService.deleteOwnerById(owner_id);
    }

}
