package org.example;

import org.example.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    private ResponseEntity<ResponseDto> testApi(){
        return ResponseEntity.ok().body(new ResponseDto<>(
                HttpStatus.OK.value(),
                "health"
        ));
    }
}
