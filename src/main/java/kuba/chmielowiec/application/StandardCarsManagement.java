package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.*;
import org.springframework.transaction.annotation.Transactional;

public class StandardCarsManagement implements CarsManagement{

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
