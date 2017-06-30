package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

    public Vehicle find(String vin) {
        return null;
    }

    public Vehicle load(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }

    public Reading updateReading(Reading reading) {
        em.persist(reading.getTires());
        em.persist(reading);

        return reading;
    }

    public Vehicle update(Vehicle vehicle) {
        return em.merge(vehicle);
    }

}
