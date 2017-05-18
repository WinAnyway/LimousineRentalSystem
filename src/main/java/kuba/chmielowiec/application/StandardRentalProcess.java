package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StandardRentalProcess implements RentalProcess{

    private CarRepository carRepository;
    private RentalRepository rentalRepository;
    private ClientRepository clientRepository;

    public StandardRentalProcess(CarRepository carRepository, RentalRepository rentalRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public String rent(RegistrationNumber registrationNumber, RentalInfo rentalInfo) {
        Car car = carRepository.get(registrationNumber);
        if(car.isAvailable()) {
            rent(rentalInfo, car);
            return String.format("You have successfully rented a %s %s", car.getBrand(), car.getModel());
        }
        return "We are sorry, this car is currently not available for rent";
    }

    private void rent(RentalInfo rentalInfo, Car car) {
        Client client = clientRepository.get(rentalInfo.getClientId());
        car.rent();
        LocalDate from = LocalDate.parse(rentalInfo.getFrom(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate to = LocalDate.parse(rentalInfo.getTo(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        rentalRepository.put(new Rental(client, car, from, to));
    }

}
