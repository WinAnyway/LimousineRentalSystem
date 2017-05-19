package kuba.chmielowiec.application;

import kuba.chmielowiec.application.dtos.ClientDto;
import kuba.chmielowiec.application.dtos.RentalHistory;

public interface ClientCatalog {
    RentalHistory getRentalHistoryOf(Long clientId);

    ClientDto get(Long clientId);
}
