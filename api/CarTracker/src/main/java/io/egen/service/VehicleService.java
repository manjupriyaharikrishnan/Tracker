package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle find(String vin);
    List<Vehicle> load(List<Vehicle> vehicles);
    Reading updateReading(Reading reading);
    Vehicle update(String vin,Vehicle vehicle);
}
