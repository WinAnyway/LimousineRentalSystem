package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.domain.rental.Rental;
import kuba.chmielowiec.domain.rental.RentalRepository;

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
