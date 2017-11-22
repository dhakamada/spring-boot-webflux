package br.com.dhakamada.webflux.springbootwebflux.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by dhakamada on 19/11/17.
 */

public interface ProductHandler {
    public Mono<ServerResponse> getProductFromRepository(ServerRequest request);

    public Mono<ServerResponse> saveProductToRepository(ServerRequest request);

    public Mono<ServerResponse> getAllProductsFromRepository(ServerRequest request);
}
