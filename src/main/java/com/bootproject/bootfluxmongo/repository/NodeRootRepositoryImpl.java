package com.bootproject.bootfluxmongo.repository;

import com.bootproject.bootfluxmongo.model.NodeRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NodeRootRepositoryImpl implements NodeBaseRepository<NodeRoot>{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<NodeRoot> getAll() {
        return mongoTemplate.findAll(NodeRoot.class);
    }

    @Override
    public boolean delete(String id) {
        return mongoTemplate.remove(get(id)).getDeletedCount() != 0;
    }

    @Override
    public NodeRoot add(NodeRoot entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public NodeRoot get(String id) {
        return mongoTemplate.findById(id, NodeRoot.class);
    }


}
