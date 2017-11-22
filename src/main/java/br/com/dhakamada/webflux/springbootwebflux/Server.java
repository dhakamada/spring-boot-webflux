package br.com.dhakamada.webflux.springbootwebflux;

import br.com.dhakamada.webflux.springbootwebflux.handler.ProductHandler;
import br.com.dhakamada.webflux.springbootwebflux.handler.ProductHandlerImpl;
import br.com.dhakamada.webflux.springbootwebflux.repository.ProductRepository;
import br.com.dhakamada.webflux.springbootwebflux.repository.ProductRepositoryInMemoryImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.ipc.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by dhakamada on 19/11/17.
 */

public class Server {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startReactive("localhost", 8080);
        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        ProductRepository repository = new ProductRepositoryInMemoryImpl();
        ProductHandler handler = new ProductHandlerImpl(repository);

        return nest(path("/product"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::getProductFromRepository)
                                .andRoute(method(HttpMethod.GET), handler::getAllProductsFromRepository)
                ).andRoute(POST("/")
                        .and(contentType(APPLICATION_JSON)), handler::saveProductToRepository));
    }

    public void startReactive(String host, int port) {
        RouterFunction<?> route = routingFunction();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(host, port);
        server.newHandler(adapter).block();
    }
}