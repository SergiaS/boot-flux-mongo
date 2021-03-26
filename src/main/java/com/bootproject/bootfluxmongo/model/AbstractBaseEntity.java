package com.bootproject.bootfluxmongo.model;

public abstract class AbstractBaseEntity {

    protected int id;
    protected String name;

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
