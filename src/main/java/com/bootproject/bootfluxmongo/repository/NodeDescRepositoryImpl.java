package com.bootproject.bootfluxmongo.repository;

import com.bootproject.bootfluxmongo.model.NodeDesc;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NodeDescRepositoryImpl implements NodeBaseRepository<NodeDesc>{

    private MongoClient client;

    private MongoClient getClient() {
        if (client == null) {
            return new MongoClient("localhost", 27017);
        }
        return client;
    }

    @Override
    public List<NodeDesc> getAll() {
        MongoClient mongoClient = getClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("NodeTask");

        List<NodeDesc> response = new ArrayList<>();

        for (Document nodeDesc : collection.find()) {
            NodeDesc nd = new NodeDesc(nodeDesc.get("_id").toString(), nodeDesc.getString("name"));

            response.add(nd);
        }
        return response;
    }

    @Override
    public String delete(String id) {
        MongoClient mongoClient = getClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("NodeTask");

        String response;
        try {
            BasicDBObject filter = new BasicDBObject("_id", new ObjectId(id));
            collection.deleteOne(filter);
            response = "Successfully deleted";
        } catch (Exception e) {
            response = "There is a problem with delete!";
        }
        return response;
    }
}
