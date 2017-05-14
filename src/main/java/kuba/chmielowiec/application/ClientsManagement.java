package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.CreateClientCommand;

public interface ClientsManagement {
    void create(CreateClientCommand cmd);
}
