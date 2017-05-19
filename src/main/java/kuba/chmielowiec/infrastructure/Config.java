package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.*;
import kuba.chmielowiec.application.impl.StandardCarsManagement;
import kuba.chmielowiec.application.impl.StandardClientsManagement;
import kuba.chmielowiec.application.impl.StandardRentalProcess;
import kuba.chmielowiec.domain.car.CarRepository;
import kuba.chmielowiec.domain.client.ClientRepository;
import kuba.chmielowiec.domain.rental.RentalRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CarsManagement carsManagement(CarRepository carRepository) {
        return new StandardCarsManagement(carRepository);
    }

    @Bean
    public ClientsManagement clientsManagement(ClientRepository clientRepository) {
        return new StandardClientsManagement(clientRepository);
    }

    @Bean
    public RentalProcess rentalProcess(CarRepository carRepository, RentalRepository rentalRepository, ClientRepository clientRepository) {
        return new StandardRentalProcess(carRepository, rentalRepository, clientRepository);
    }

    @Bean
    public CarsCatalog carsCatalog() {
        return new JPACarsCatalog();
    }

    @Bean
    public ClientCatalog clientCatalog() {
        return new JPAClientCatalog();
    }

    @Bean
    public CarRepository carRepository() {
        return new JPACarRepository();
    }

    @Bean
    public ClientRepository clientRepository() {
        return new JPAClientRepository();
    }

    @Bean
    public RentalRepository rentalRepository() {
        return new JPARentalRepository();
    }
}
