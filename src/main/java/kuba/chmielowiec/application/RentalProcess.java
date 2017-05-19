package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.car.RegistrationNumber;
import kuba.chmielowiec.domain.rental.RentalInfo;

public interface RentalProcess {

    String rent(RegistrationNumber registrationNumber, RentalInfo rentalInfo);

}
