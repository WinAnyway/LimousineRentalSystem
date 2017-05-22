package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.commands.CreateClientCommand;

public interface ClientsManagement {
    void create(CreateClientCommand cmd);
}
