package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.client.Client;
import kuba.chmielowiec.domain.client.ClientRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAClientRepository implements ClientRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(Client client) {
        entityManager.persist(client);
    }

    @Override
    public Client get(Long clientId) {
        Client client = entityManager.find(Client.class, clientId);
        if (client == null)
            throw new NoResourceException(String.format("Client with id %d does not exist", clientId));
        return client;
    }
}
