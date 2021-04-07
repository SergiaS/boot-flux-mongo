package com.bootproject.bootfluxmongo.model;

public class NodeRoot extends AbstractBaseEntity {

    public NodeRoot(String name) {
        super.name = name;
    }

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
