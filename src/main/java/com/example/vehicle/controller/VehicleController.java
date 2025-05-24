package com.example.vehicle.controller;


import com.example.vehicle.model.Vehicle;
import com.example.vehicle.util.VehicleTestData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final List<Vehicle> vehicles = VehicleTestData.getTestVehicles();

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        vehicles.add(vehicle);
        return vehicle;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable long id) {
        return vehicles.stream().filter(v -> v.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));

    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable long id, @RequestBody Vehicle updatedVehicle){
      Vehicle vehicle =   vehicles.stream().filter(v -> v.getId() == id).findFirst().orElseThrow();
        vehicle.setPlateNumber(updatedVehicle.getPlateNumber());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setManufacturer(updatedVehicle.getManufacturer());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setOwnerName(updatedVehicle.getOwnerName());
        vehicle.setCreatedAt(updatedVehicle.getCreatedAt());
        vehicle.setCreatedBy(updatedVehicle.getCreatedBy());
        int oldIndex  = vehicles.indexOf(vehicle);
        vehicles.removeIf(v -> v.getId() == id);
        vehicles.add(oldIndex,vehicle);
        return vehicle;
    }

    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable long id){
        vehicles.removeIf(v-> v.getId() == id);
    }

}
