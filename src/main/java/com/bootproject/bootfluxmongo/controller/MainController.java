package com.bootproject.bootfluxmongo.controller;

import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import com.bootproject.bootfluxmongo.service.NodeDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class MainController {

    @Autowired
    private NodeDescService nodeDescService;

    @GetMapping
    public Flux<AbstractBaseEntity> list() {
        return nodeDescService.getAll();
    }

    @PostMapping
    public Mono<AbstractBaseEntity> add(@RequestBody AbstractBaseEntity nodeDesc) {
        return nodeDescService.addOne(nodeDesc);
    }
}
