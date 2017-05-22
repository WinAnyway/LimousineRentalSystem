package kuba.chmielowiec.application.impl;

import kuba.chmielowiec.domain.commands.CreateRentalCommand;
import kuba.chmielowiec.application.RentalProcess;
import kuba.chmielowiec.domain.car.Car;
import kuba.chmielowiec.domain.car.CarRepository;
import kuba.chmielowiec.domain.client.Client;
import kuba.chmielowiec.domain.client.ClientRepository;
import kuba.chmielowiec.domain.rental.Rental;
import kuba.chmielowiec.domain.rental.RentalRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StandardRentalProcess implements RentalProcess {

    private final String CORRECT_DATE_FORMAT = "yyyy/MM/dd";
    private final String CAR_NOT_AVAILABLE = "We are sorry, this car is currently not available for rental";
    private final String CAR_RENTED = "You have successfully rented a %s %s";

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
    public String rent(CreateRentalCommand cmd) {
        Car car = carRepository.get(cmd.getRegistrationNumber());
        if(car.isAvailable()) {
            createRental(cmd, car);
            return String.format(CAR_RENTED, car.getBrand(), car.getModel());
        }
        return CAR_NOT_AVAILABLE;
    }

    private void createRental(CreateRentalCommand cmd, Car car) {
        Client client = clientRepository.get(cmd.getClientId());
        car.rent();
        LocalDate from = LocalDate.parse(cmd.getFrom(), DateTimeFormatter.ofPattern(CORRECT_DATE_FORMAT));
        LocalDate to = LocalDate.parse(cmd.getTo(), DateTimeFormatter.ofPattern(CORRECT_DATE_FORMAT));
        rentalRepository.put(new Rental(client, car, from, to));
    }

}
