package kuba.chmielowiec.application;

public interface ClientCatalog {
    RentalHistory getRentalHistoryOf(Long clientId);

    ClientDto get(Long clientId);
}
