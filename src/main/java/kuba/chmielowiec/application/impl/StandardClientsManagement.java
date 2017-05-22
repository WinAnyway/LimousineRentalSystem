package kuba.chmielowiec.application.impl;

import kuba.chmielowiec.application.ClientsManagement;
import kuba.chmielowiec.domain.client.Client;
import kuba.chmielowiec.domain.client.ClientRepository;
import kuba.chmielowiec.domain.commands.CreateClientCommand;
import org.springframework.transaction.annotation.Transactional;

public class StandardClientsManagement implements ClientsManagement {

    private ClientRepository clientRepository;

    public StandardClientsManagement(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public void create(CreateClientCommand cmd) {
        clientRepository.put(new Client(cmd));
    }

}
