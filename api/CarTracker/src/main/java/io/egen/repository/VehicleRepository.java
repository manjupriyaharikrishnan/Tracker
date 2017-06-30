package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VehicleRepository {
    Vehicle find(String vin);
    Vehicle load(Vehicle vehicle);
    Reading updateReading(Reading reading);
    Vehicle update(Vehicle vehicle);
}
