package org.example.config;

import org.example.model.Client;
import org.example.service.client.ClientService;
import org.example.service.client.ClientServiceImpl;
import org.example.service.gateway.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientRepository clientRepository(){

        return new ClientRepository() {

            private List<Client> clients = List.of(
                    new Client("C",
                            "123",
                            "Johnathan",
                            "Arley",
                            "Monsalve",
                            "bello",
                            "123456789",
                            "calle san juan",
                            "med"
                    )
            );
            @Override
            public Optional<List<Client>> getClients() {
                return Optional.of(clients);
            }

            @Override
            public Optional<Client> getClientByID(String idType, String idNumber) {
                return clients.stream()
                        .filter(getClientPredicate(idType, idNumber))
                        .findFirst();
            }

            private static Predicate<Client> getClientPredicate(String idType, String idNumber) {
                return client -> Objects.equals(client.idType(), idType) && Objects.equals(client.idNumber(), idNumber);
            }

            @Override
            public Optional<Client> save(Client client) {
                return Optional.empty();
            }

            @Override
            public Optional<Client> delete(String idType, String idNumber) {
                return Optional.empty();
            }
        };
    }

    @Bean
    public ClientService clientService(){
        return new ClientServiceImpl(clientRepository());
    }
}
