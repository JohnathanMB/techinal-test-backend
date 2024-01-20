package org.example;

import org.example.model.ResponseDto;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ResponseDto> handleError() {

        return ResponseEntity
                .internalServerError()
                .body(
                        new ResponseDto<>(
                                HttpStatus.NOT_IMPLEMENTED.value(),
                                "System error, please try againd in a while"
                        )
                );
    }

}
