package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.Car;
import kuba.chmielowiec.domain.CarRepository;
import kuba.chmielowiec.domain.CreateCarCommand;

public class StandardCarsManagement implements CarsManagement{

    private CarRepository carRepository;

    public StandardCarsManagement(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void create(CreateCarCommand cmd) {
        carRepository.put(new Car(cmd));
    }
}
