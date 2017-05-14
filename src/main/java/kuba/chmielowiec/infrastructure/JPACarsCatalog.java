package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.CarDto;
import kuba.chmielowiec.application.CarsCatalog;
import kuba.chmielowiec.domain.Car;
import kuba.chmielowiec.domain.RegistrationNumber;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

public class JPACarsCatalog implements CarsCatalog{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = entityManager.createQuery("select c from Car c").getResultList();
        return cars.stream().map(c -> new CarDto(c.getRegistrationNumber().getNumber(), c.getBrand(), c.getModel(), c.getYear()))
                .collect(Collectors.toList());
    }

    @Override
    public CarDto get(RegistrationNumber registrationNumber) {
        Car car = entityManager.find(Car.class, registrationNumber);
        return new CarDto(car.getRegistrationNumber().getNumber(), car.getBrand(), car.getModel(), car.getYear());
    }

}
