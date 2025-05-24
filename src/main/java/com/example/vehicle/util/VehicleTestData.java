package com.example.vehicle.util;


import com.example.vehicle.model.Vehicle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VehicleTestData {


    public static List<Vehicle> getTestVehicles() {
          List<Vehicle> vehicles = new ArrayList<>();


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(1L);
        vehicle1.setPlateNumber("ABC123");
        vehicle1.setModel("Civic");
        vehicle1.setManufacturer("Honda");
        vehicle1.setYear(2020);
        vehicle1.setOwnerName("John Doe");
        vehicle1.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        vehicle1.setCreatedBy("Ahmed Ali");
        vehicles.add(vehicle1);


        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(2L);
        vehicle2.setPlateNumber("XYZ789");
        vehicle2.setModel("Corolla");
        vehicle2.setManufacturer("Toyota");
        vehicle2.setYear(2018);
        vehicle2.setOwnerName("Jane Smith");
        vehicle2.setCreatedAt(new Timestamp(System.currentTimeMillis() - 86400000));
        vehicle2.setCreatedBy("Fatima Khan");
        vehicles.add(vehicle2);


        Vehicle vehicle3 = new Vehicle();
        vehicle3.setId(3L);
        vehicle3.setPlateNumber("LMN456");
        vehicle3.setModel("Model 3");
        vehicle3.setManufacturer("Tesla");
        vehicle3.setYear(2022);
        vehicle3.setOwnerName("Bob Johnson");
        vehicle3.setCreatedAt(new Timestamp(System.currentTimeMillis() - 172800000));
        vehicle3.setCreatedBy("Sara Ali");
        vehicles.add(vehicle3);

        return vehicles;
    }


}