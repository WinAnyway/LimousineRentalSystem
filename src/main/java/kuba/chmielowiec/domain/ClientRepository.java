package kuba.chmielowiec.domain;

public interface ClientRepository {
    void put(Client client);

    Client get(Long clientId);
}
