package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.Rental;
import kuba.chmielowiec.domain.RentalRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPARentalRepository implements RentalRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void put(Rental rental) {
        entityManager.persist(rental);
    }
}
