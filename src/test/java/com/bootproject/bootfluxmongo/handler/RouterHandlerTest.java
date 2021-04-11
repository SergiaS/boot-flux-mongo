package com.bootproject.bootfluxmongo.handler;

import com.bootproject.bootfluxmongo.dto.DTOEntity;
import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import com.bootproject.bootfluxmongo.model.NodeDesc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureWebTestClient
class RouterHandlerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void getAll() {
        webTestClient.get().uri("/controllerV2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DTOEntity.class);
    }

    @Test
    void addOne() {
        AbstractBaseEntity newNode = new NodeDesc("33", "Carlos", "Sales");

        webTestClient.post().uri("/controllerV2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(newNode), AbstractBaseEntity.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isNotEmpty()
                .jsonPath("$.name").isEqualTo(newNode.getName());
    }
}
