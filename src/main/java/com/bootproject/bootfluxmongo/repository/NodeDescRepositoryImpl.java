package com.bootproject.bootfluxmongo.repository;

import com.bootproject.bootfluxmongo.model.NodeDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NodeDescRepositoryImpl implements NodeBaseRepository<NodeDesc> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<NodeDesc> getAll() {
        return mongoTemplate.findAll(NodeDesc.class);
    }

    @Override
    public boolean delete(String id) {
        return mongoTemplate.remove(get(id)).getDeletedCount() != 0;
    }

    @Override
    public NodeDesc add(NodeDesc entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public NodeDesc get(String id) {
        return mongoTemplate.findById(id, NodeDesc.class);
    }
}
