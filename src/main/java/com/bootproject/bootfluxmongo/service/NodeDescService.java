package com.bootproject.bootfluxmongo.service;

import com.bootproject.bootfluxmongo.dto.DTOEntity;
import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import com.bootproject.bootfluxmongo.repository.NodeDescRepository;
import com.bootproject.bootfluxmongo.util.NodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NodeDescService {

    @Autowired
    private NodeDescRepository repository;

    public Flux<AbstractBaseEntity> getAll() {
        return repository.findAll();
    }

    public Mono<AbstractBaseEntity> addOne(DTOEntity dtoEntity) {
        AbstractBaseEntity baseEntity = NodeUtil.getNode(dtoEntity);
        return repository.save(baseEntity);
    }
}
