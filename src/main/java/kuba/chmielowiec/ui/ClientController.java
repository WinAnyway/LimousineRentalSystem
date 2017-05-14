package kuba.chmielowiec.ui;

import kuba.chmielowiec.application.ClientCatalog;
import kuba.chmielowiec.application.ClientDto;
import kuba.chmielowiec.application.ClientsManagement;
import kuba.chmielowiec.application.RentalHistory;
import kuba.chmielowiec.domain.CreateClientCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientsManagement clientsManagement;
    private ClientCatalog clientCatalog;

    public ClientController(ClientsManagement clientsManagement, ClientCatalog clientCatalog) {
        this.clientsManagement = clientsManagement;
        this.clientCatalog = clientCatalog;
    }

    @PutMapping
    public void createClient(@RequestBody CreateClientCommand cmd) {
        clientsManagement.create(cmd);
    }

    @GetMapping("/{clientId}/rental-history")
    public RentalHistory getRentalsOfClient(@PathVariable Long clientId) {
        return clientCatalog.getRentalHistoryOf(clientId);
    }

    @GetMapping("/{clientId}")
    public ClientDto showClient(@PathVariable Long clientId) {
        return clientCatalog.get(clientId);
    }
}
