package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.RegistrationNumber;

public interface RentalProcess {

    String rent(RegistrationNumber registrationNumber, RentalInfo rentalInfo);

}
