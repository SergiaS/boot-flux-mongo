package com.bootproject.bootfluxmongo.controller;

import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.model.NodeRoot;
import com.bootproject.bootfluxmongo.repository.NodeDescRepositoryImpl;
import com.bootproject.bootfluxmongo.repository.NodeRootRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NodeRestController {

    @Autowired
    private NodeRootRepositoryImpl nodeRootRepository;

    @Autowired
    private NodeDescRepositoryImpl nodeDescRepository;


    // for NodeRoot
    @GetMapping("/rootNodes")
    public List<NodeRoot> getAllNodeRoots() {
        return nodeRootRepository.getAll();
    }

    @PostMapping("/rootNodes")
    public String addNodeRoot(String id) {
        return nodeRootRepository.delete(id);
    }


    // for NodeDesc
    @GetMapping("/descriptionNodes")
    public List<NodeDesc> getAllNodeDescriptions() {
        return nodeDescRepository.getAll();
    }

    @PostMapping("/descriptionNodes")
    public String addNodeDesc(String id) {
        return nodeDescRepository.delete(id);
    }
}
