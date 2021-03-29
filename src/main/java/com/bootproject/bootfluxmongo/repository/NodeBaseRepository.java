package com.bootproject.bootfluxmongo.repository;

import java.util.List;

public interface NodeBaseRepository<T> {

    List<T> getAll();

    String delete(String id);

    String add(T entity);
}
