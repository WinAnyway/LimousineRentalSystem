package kuba.chmielowiec.infrastructure;

import kuba.chmielowiec.application.ClientCatalog;
import kuba.chmielowiec.application.ClientDto;
import kuba.chmielowiec.application.RentalHistory;

public class JPAClientCatalog implements ClientCatalog{

    @Override
    public RentalHistory getRentalHistoryOf(Long clientId) {
        return null;
    }

    @Override
    public ClientDto get(Long clientId) {
        return null;
    }

}
