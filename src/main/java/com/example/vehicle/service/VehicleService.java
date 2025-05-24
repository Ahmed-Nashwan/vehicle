package com.example.vehicle.service;

import com.example.vehicle.exception.DuplicatePlateNumberException;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(long id){
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with ID " + id + " not found"));
    }

    public Vehicle addVehicle(Vehicle vehicle){
        if(vehicleRepository.existsByPlateNumber(vehicle.getPlateNumber())) {
            throw new RuntimeException("Vehicle with plate number " + vehicle.getPlateNumber() + " already exists.");
        }
       return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(long id, Vehicle updatedVehicle){
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Vehicle with ID " + id + " not found"));

        if(vehicleRepository.existsByPlateNumber(updatedVehicle.getPlateNumber())) //because plate number must be unique
            throw new  DuplicatePlateNumberException("Vehicle with ID " + updatedVehicle.getPlateNumber() + "already exists");

        vehicle.setCreatedAt(updatedVehicle.getCreatedAt());
        vehicle.setManufacturer(updatedVehicle.getManufacturer());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setPlateNumber(updatedVehicle.getPlateNumber());
        vehicle.setOwnerName(updatedVehicle.getOwnerName());

       return vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(long id){
        if(!vehicleRepository.existsById(id))
            throw new ResourceNotFoundException("Vehicle with ID " + id + " not found");

        vehicleRepository.deleteById(id);
    }
}
