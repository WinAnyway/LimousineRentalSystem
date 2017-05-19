package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.client.CreateClientCommand;

public interface ClientsManagement {
    void create(CreateClientCommand cmd);
}
