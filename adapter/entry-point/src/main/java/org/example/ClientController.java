package org.example;

import org.example.model.Client;
import org.example.model.ResponseDto;
import org.example.service.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/hi")
    private ResponseEntity<String> testApi(){
        return new ResponseEntity<>("HOLA", HttpStatus.ACCEPTED);
    }

    @GetMapping("/clients")
    private ResponseEntity<ResponseDto> getClients(){

        List<Client> clients = clientService.getClients();
        return validateContent(!clients.isEmpty(), clients);

    }

    @GetMapping("/clients/{idType}/{idNumber}")
    private ResponseEntity<ResponseDto> getClient(@PathVariable("idType") String idType,
                                                  @PathVariable("idNumber") String idNumber){

        Client client = clientService.getClient(idType.toUpperCase(), idNumber);
        return validateContent(!client.idType().isEmpty(), client);
    }

    @PostMapping("/clients")
    private ResponseEntity<ResponseDto> createClient(@RequestBody Client client){

        Client savedClient = clientService.save(client);
        return validateContent(!client.idType().isEmpty(), savedClient);
    }

    @PatchMapping("/clients")
    private ResponseEntity<ResponseDto> updateClient(@RequestBody Client client){
        Client updatedClient = clientService.update(client);
        return validateContent(!updatedClient.idType().isEmpty(), updatedClient);
    }

    @DeleteMapping("/clients/{idType}/{idNumber}")
    private ResponseEntity<ResponseDto> removeClient(@PathVariable("idType") String idType,
                                                     @PathVariable("idNumber") String idNumber){
        Client deletedClient = clientService.delete(idType, idNumber);
        return validateContent(!deletedClient.idType().isEmpty(), deletedClient);
    }

    private static ResponseEntity<ResponseDto> validateContent(boolean validation, Object body) {
        return validation
                ? ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), body))
                : ResponseEntity.badRequest().body(new ResponseDto<>(HttpStatus.NOT_FOUND.value(), "Client Not found"));
    }

}
