package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.RegistrationNumber;

import java.util.List;

public interface CarsCatalog {
    List<CarDto> getAllCars();

    CarDto get(RegistrationNumber registrationNumber);
}
