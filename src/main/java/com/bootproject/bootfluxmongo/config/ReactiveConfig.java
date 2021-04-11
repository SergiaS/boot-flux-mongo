package com.bootproject.bootfluxmongo.config;

import com.bootproject.bootfluxmongo.handler.RouterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ReactiveConfig {

    @Bean
    public RouterFunction<ServerResponse> route(RouterHandler routerHandler) {
        return RouterFunctions
                .route(GET("/controllerV2")
                        .and(accept(MediaType.APPLICATION_JSON)), routerHandler::getAll)
                .andRoute(POST("/controllerV2")
                        .and(accept(MediaType.APPLICATION_JSON)), routerHandler::addOne);
    }
}
