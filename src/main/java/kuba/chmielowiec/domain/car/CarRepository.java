package kuba.chmielowiec.domain.car;

public interface CarRepository {
    void put(Car car);

    Car get(RegistrationNumber registrationNumber);
}
