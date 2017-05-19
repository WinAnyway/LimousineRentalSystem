package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.*;
import kuba.chmielowiec.domain.Car;
import kuba.chmielowiec.domain.Client;
import kuba.chmielowiec.domain.Rental;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class JPAClientCatalog implements ClientCatalog{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RentalHistory getRentalHistoryOf(Long clientId) {
        Query query = entityManager.createQuery("select r from Rental r join fetch r.car c join fetch r.client cl where cl.id = :id");
        query.setParameter("id", clientId);
        List<Rental> rentals = query.getResultList();
        return new RentalHistory(clientId, mapToDtos(rentals));
    }

    private List<RentalDto> mapToDtos(List<Rental> rentals) {
        return rentals.stream().
                map(r -> new RentalDto(createCarDto(r.getCar()), r.getStartDate(), r.getEndDate(), r.getStatus())).
                collect(Collectors.toList());
    }

    private CarDto createCarDto(Car car) {
        return new CarDto(car.getRegistrationNumber().getNumber(), car.getBrand(), car.getModel(), car.getYear());
    }

    @Override
    public ClientDto get(Long clientId) {
        Client client = entityManager.find(Client.class, clientId);
        return new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getPesel(), client.getAddress());
    }

}
