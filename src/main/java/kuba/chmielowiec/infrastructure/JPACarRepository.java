package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.car.Car;
import kuba.chmielowiec.domain.car.CarRepository;
import kuba.chmielowiec.domain.car.RegistrationNumber;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPACarRepository implements CarRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(Car car) {
        entityManager.persist(car);
    }

    @Override
    public Car get(RegistrationNumber registrationNumber) {
        Car car = entityManager.find(Car.class, registrationNumber);
        if (car == null)
            throw new NoResourceException(String.format("Car with registration number %s does not exist", registrationNumber.getNumber()));
        return car;
    }

}
