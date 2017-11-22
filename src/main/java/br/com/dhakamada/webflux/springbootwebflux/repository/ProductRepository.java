package br.com.dhakamada.webflux.springbootwebflux.repository;

import br.com.dhakamada.webflux.springbootwebflux.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by dhakamada on 19/11/17.
 */


public interface ProductRepository {

    Mono<Product> getProduct(int id);

    Flux<Product> getAllProducts();

    Mono<Void> saveProduct(Mono<Product> product);

}
