package org.example.service.gateway;

import org.example.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<List<Client>> getClients();
    Optional<Client> getClientByID(String idType, String idNumber);

    Optional<Client> save(Client client);

    Optional<Client> delete(String idType, String idNumber);

}
