package com.bootproject.bootfluxmongo.model;

import org.springframework.data.annotation.PersistenceConstructor;

public class NodeRoot extends AbstractBaseEntity {

    public NodeRoot(String name) {
        super.name = name;
    }

    @PersistenceConstructor
    public NodeRoot(String id, String name) {
        super.id = id;
        super.name = name;
    }

    @Override
    public String toString() {
        return "NodeRoot{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
