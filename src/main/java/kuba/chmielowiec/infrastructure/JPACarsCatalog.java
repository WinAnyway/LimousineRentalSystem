package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.dtos.CarDto;
import kuba.chmielowiec.application.CarsCatalog;
import kuba.chmielowiec.domain.car.Car;
import kuba.chmielowiec.domain.car.RegistrationNumber;

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
        if(car == null)
            throw new NoResourceException(String.format("Car with registration number %s does not exist", registrationNumber.getNumber()));
        return new CarDto(car.getRegistrationNumber().getNumber(), car.getBrand(), car.getModel(), car.getYear());
    }

}
