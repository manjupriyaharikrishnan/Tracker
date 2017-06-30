package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImplementation implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle find(String vin) {
        Vehicle existing = repository.find(vin);
        if (existing != null) {
            return existing;
        } else {
            return existing;
        }
    }

    @Transactional
    public List<Vehicle> load(List<Vehicle> vehicles) {
        for(Vehicle v: vehicles)
        {
            Vehicle existing = repository.find(v.getVin());
            if(existing!=null)
            {
                repository.update(v);
            }else{
                repository.load(v);
            }
        }
        return vehicles;
    }

    @Transactional
    public Reading updateReading(Reading reading) {
        return repository.updateReading(reading);
    }

    public Vehicle update(String vin, Vehicle vehicle) {
        return null;
    }
}
