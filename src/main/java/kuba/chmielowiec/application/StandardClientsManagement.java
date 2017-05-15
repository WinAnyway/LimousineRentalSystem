package kuba.chmielowiec.application;

import kuba.chmielowiec.domain.Client;
import kuba.chmielowiec.domain.ClientRepository;
import kuba.chmielowiec.domain.CreateClientCommand;
import org.springframework.transaction.annotation.Transactional;

public class StandardClientsManagement implements ClientsManagement{

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
