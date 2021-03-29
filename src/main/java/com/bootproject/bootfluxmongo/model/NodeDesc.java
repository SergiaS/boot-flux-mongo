package com.bootproject.bootfluxmongo.model;

public class NodeDesc extends AbstractBaseEntity {

    private String description;

    public NodeDesc(String id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NodeDesc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
