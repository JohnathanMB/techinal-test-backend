package org.example;

import org.example.model.Client;
import org.example.model.ResponseDto;
import org.example.service.client.ClientService;
import org.example.service.client.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/hi")
    private ResponseEntity<String> testApi(){
        return new ResponseEntity<String>("HOLA", HttpStatus.ACCEPTED);
    }

    @GetMapping("/client/{idType}/{idNumber}")
    private ResponseEntity<ResponseDto> getClient(@PathVariable("idType") String idType,
                                                  @PathVariable("idNumber") String idNumber){

        Client client = clientService.getClient(idType.toUpperCase(), idNumber);

        return !client.idType().isEmpty()
                ? ResponseEntity.ok().body(new ResponseDto<>(HttpStatus.OK.value(), client))
                : ResponseEntity.badRequest().body(new ResponseDto<>(HttpStatus.OK.value(), "Client No found"));

    }

}
