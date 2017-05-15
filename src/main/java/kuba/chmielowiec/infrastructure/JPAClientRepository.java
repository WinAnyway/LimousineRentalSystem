package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.Client;
import kuba.chmielowiec.domain.ClientRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAClientRepository implements ClientRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(Client client) {
        entityManager.persist(client);
    }
}
