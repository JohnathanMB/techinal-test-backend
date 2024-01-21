package org.example.config;

import org.example.model.Client;
import org.example.service.client.ClientService;
import org.example.service.client.ClientServiceImpl;
import org.example.service.gateway.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientRepository clientRepository(){

        return new TemporalRepository();
    }

    @Bean
    public ClientService clientService(){
        return new ClientServiceImpl(clientRepository());
    }
}
