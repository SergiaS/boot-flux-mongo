package com.bootproject.bootfluxmongo.handler;

import com.bootproject.bootfluxmongo.dto.DTOEntity;
import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.repository.NodeDescRepository;
import com.bootproject.bootfluxmongo.util.NodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class RouterHandler {

    @Autowired
    private NodeDescRepository repository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ok()
                .body(repository.findAll(), NodeDesc.class);
    }

    public Mono<ServerResponse> addOne(ServerRequest request) {
        return request.bodyToMono(DTOEntity.class)
                .flatMap(node -> repository.save(NodeUtil.getNode(node)))
                .flatMap(node -> ok().bodyValue(node));
    }

}
