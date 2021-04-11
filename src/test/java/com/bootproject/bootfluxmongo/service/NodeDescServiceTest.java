package com.bootproject.bootfluxmongo.service;

import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.repository.NodeDescRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureWebTestClient
class NodeDescServiceTest {

    @Autowired
    NodeDescRepository repository;

    @Test
    void getAll() {
        Flux<AbstractBaseEntity> dbObjects = repository.findAll();

        StepVerifier.create(dbObjects)
                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void addOne() {
        NodeDesc nodeDesc = new NodeDesc("15", "George", "IT");

        Mono<AbstractBaseEntity> foundedById = repository.save(nodeDesc)
                .map(n -> n.getId())
                .flatMap(id -> repository.findById(id));

        StepVerifier.create(foundedById)
                .assertNext(node -> {
                    assertThat(node).isNotNull();
                    assertThat(node.getId()).isEqualTo(nodeDesc.getId());
                    assertThat(node.getName()).isEqualTo(nodeDesc.getName());
                    assertThat(((NodeDesc)node).getDescription()).isEqualTo(nodeDesc.getDescription());
                })
                .verifyComplete();
    }
}
