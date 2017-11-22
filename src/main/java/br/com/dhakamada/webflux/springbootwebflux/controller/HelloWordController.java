package br.com.dhakamada.webflux.springbootwebflux.controller;

import br.com.dhakamada.webflux.springbootwebflux.dto.OperationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by dhakamada on 19/11/17.
 */
@RestController
public class HelloWordController {

    @GetMapping(value = "/")
    public Mono<String> helloWorld() {
        return Mono.just("Teste");
    }

    @PostMapping(value = "/")
    public Mono<OperationDTO> postHello() {
        OperationDTO data = new OperationDTO();
        data.setUuid(UUID.randomUUID().toString());
        return Mono.just(data);
    }
}
