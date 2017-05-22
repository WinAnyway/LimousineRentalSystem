package kuba.chmielowiec.application.impl;

import kuba.chmielowiec.application.CarsManagement;
import kuba.chmielowiec.domain.car.Car;
import kuba.chmielowiec.domain.car.CarRepository;
import kuba.chmielowiec.domain.commands.CreateCarCommand;
import org.springframework.transaction.annotation.Transactional;

public class StandardCarsManagement implements CarsManagement {

    private CarRepository carRepository;

    public StandardCarsManagement(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public void create(CreateCarCommand cmd) {
        carRepository.put(new Car(cmd));
    }

}
