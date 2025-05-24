package com.example.vehicle.controller;


import com.example.vehicle.exception.DuplicatePlateNumberException;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addVehicle(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
      List<Vehicle> vehicles =  service.getAllVehicles();
    return vehicles.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(vehicles);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {
       return ResponseEntity.ok(service.getVehicleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable long id, @RequestBody Vehicle updatedVehicle){
        return ResponseEntity.ok(service.updateVehicle(id,updatedVehicle));
    }

    @DeleteMapping("{id}")
    public void deleteVehicle(@PathVariable long id){
        service.deleteVehicleById(id);
    }
}
