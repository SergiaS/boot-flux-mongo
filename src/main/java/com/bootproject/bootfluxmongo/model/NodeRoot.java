package com.bootproject.bootfluxmongo.model;

public class NodeRoot extends AbstractBaseEntity {

    private String description;

    public NodeRoot(int id, String name, String description) {
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
        return "NodeRoot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
