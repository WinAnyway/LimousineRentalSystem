package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.ClientCatalog;
import kuba.chmielowiec.application.ClientDto;
import kuba.chmielowiec.application.RentalHistory;
import kuba.chmielowiec.domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAClientCatalog implements ClientCatalog{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RentalHistory getRentalHistoryOf(Long clientId) {
        return null;
    }

    @Override
    public ClientDto get(Long clientId) {
        Client client = entityManager.find(Client.class, clientId);
        return new ClientDto(client.getId(), client.getFirstName(), client.getLastName(), client.getPesel(), client.getAddress());
    }

}
