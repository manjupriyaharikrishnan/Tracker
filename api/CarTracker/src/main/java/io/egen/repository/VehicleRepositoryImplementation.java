package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle find(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle load(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Reading updateReading(Reading reading) {
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);

        return reading;
    }

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

}
