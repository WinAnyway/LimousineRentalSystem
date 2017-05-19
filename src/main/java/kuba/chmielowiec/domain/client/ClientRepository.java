package kuba.chmielowiec.domain.client;

public interface ClientRepository {
    void put(Client client);

    Client get(Long clientId);
}
