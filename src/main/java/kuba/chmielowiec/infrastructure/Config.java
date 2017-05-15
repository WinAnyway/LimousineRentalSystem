package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.*;
import kuba.chmielowiec.domain.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CarsManagement carsManagement(CarRepository carRepository) {
        return new StandardCarsManagement(carRepository);
    }

    @Bean
    public ClientsManagement clientsManagement() {
        return new StandardClientsManagement();
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
}
