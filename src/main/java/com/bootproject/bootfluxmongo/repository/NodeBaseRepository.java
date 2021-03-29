package com.bootproject.bootfluxmongo.repository;

import java.util.List;

public interface NodeBaseRepository<T> {

    List<T> getAll();

    boolean delete(String id);

    T add(T entity);

    T get(String id);
}
