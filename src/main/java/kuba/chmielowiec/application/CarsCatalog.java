package kuba.chmielowiec.application;

import kuba.chmielowiec.application.dtos.CarDto;
import kuba.chmielowiec.domain.car.RegistrationNumber;

import java.util.List;

public interface CarsCatalog {
    List<CarDto> getAllCars();

    CarDto get(RegistrationNumber registrationNumber);
}
