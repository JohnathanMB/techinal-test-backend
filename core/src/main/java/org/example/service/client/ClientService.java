package org.example.service.client;

import org.example.model.Client;

import java.lang.ref.Cleaner;
import java.util.List;

public interface ClientService {

    List<Client> getClients();
    Client getClient(String idType, String idNumber);
    Client save(Client client);
    Client update(Client client);
    Client delete(String idType, String idNumber);

}
