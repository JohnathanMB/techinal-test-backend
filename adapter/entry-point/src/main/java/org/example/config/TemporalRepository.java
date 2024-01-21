package org.example.config;

import org.example.model.Client;
import org.example.service.gateway.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TemporalRepository implements ClientRepository {

    private static final Client client = new Client("C",
            "23445322",
            "Johnathan",
            "Arley",
            "Monsalve",
            "bello",
            "123456789",
            "calle san juan",
            "med"
    );

    private Map<String, Client> clients = new HashMap<>(
            Map.of(client.idType().concat(client.idNumber()), client)
    );


    @Override
    public Optional<List<Client>> getClients() {
        return Optional.of(clients.values().stream().toList());
    }

    @Override
    public Optional<Client> getClientByID(String idType, String idNumber) {

        return Optional.ofNullable(clients.get(idType.concat(idNumber)));
    }

    @Override
    public Optional<Client> save(Client client) {
        String key =  client.idType().concat(client.idNumber());
        clients.put(key,client);
        return Optional.ofNullable(clients.get(key));
    }

    @Override
    public Optional<Client> delete(String idType, String idNumber) {
        return Optional.ofNullable(clients.remove(idType.concat(idNumber)));
    }

}
