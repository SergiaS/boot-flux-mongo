package com.bootproject.bootfluxmongo.controller;

import com.bootproject.bootfluxmongo.model.NodeRoot;
import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.bootproject.bootfluxmongo.repository.NodeDescRepositoryImpl;
import com.bootproject.bootfluxmongo.repository.NodeRootRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @DeleteMapping("/rootNodes")
    public String deleteNodeRoots(@PathParam("id") String id) {
        return nodeRootRepository.delete(id);
    }

    @PostMapping("/rootNodes")
    public String addNodeRoots(@RequestBody NodeRoot nodeRoot) {
        return nodeRootRepository.add(nodeRoot);
    }


    // for NodeDesc
    @GetMapping("/descriptionNodes")
    public List<NodeDesc> getAllNodeDescriptions() {
        return nodeDescRepository.getAll();
    }

    @DeleteMapping("/descriptionNodes")
    public String deleteNodeDesc(@PathParam("id") String id) {
        return nodeDescRepository.delete(id);
    }

    @PostMapping("/descriptionNodes")
    public String addNodeDesc(@RequestBody NodeDesc nodeDesc) {
        return nodeDescRepository.add(nodeDesc);
    }
}
