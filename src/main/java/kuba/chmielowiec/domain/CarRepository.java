package kuba.chmielowiec.domain;

public interface CarRepository {
    void put(Car car);

    Car get(RegistrationNumber registrationNumber);
}
