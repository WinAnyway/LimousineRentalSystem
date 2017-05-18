package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.Car;
import kuba.chmielowiec.domain.CarRepository;
import kuba.chmielowiec.domain.RegistrationNumber;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPACarRepository implements CarRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(Car car) {
        entityManager.persist(car);
    }

    @Override
    public Car get(RegistrationNumber registrationNumber) {
        return entityManager.find(Car.class, registrationNumber);
    }

}
