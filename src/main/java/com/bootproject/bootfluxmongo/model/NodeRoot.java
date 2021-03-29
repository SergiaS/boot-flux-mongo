package com.bootproject.bootfluxmongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NodeRoot extends AbstractBaseEntity {

    public NodeRoot(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "NodeRoot{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
