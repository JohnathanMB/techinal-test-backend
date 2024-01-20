package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class ClientController {

    @GetMapping("/hi")
    private ResponseEntity<String> testApi(){
        return new ResponseEntity<String>("HOLA", HttpStatus.ACCEPTED);
    }

}
