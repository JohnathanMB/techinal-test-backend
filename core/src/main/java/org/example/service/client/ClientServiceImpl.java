package org.example.service.client;

import org.example.model.Client;
import org.example.service.gateway.ClientRepository;

import java.util.Collections;
import java.util.List;

public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.getClients().orElseGet(Collections::emptyList);
    }

    @Override
    public Client getClient(String idType, String idNumber) {
        return clientRepository.getClientByID(idType, idNumber).orElseGet(Client::new);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client).orElseGet(Client::new);
    }

    @Override
    public Client update(Client client) {
        return this.save(client);
    }

    @Override
    public Client delete(String idType, String idNumber) {
        return clientRepository.delete(idType, idNumber).orElseGet(Client::new);
    }
}
