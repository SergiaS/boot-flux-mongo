package com.bootproject.bootfluxmongo.repository;

import com.bootproject.bootfluxmongo.model.AbstractBaseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeDescRepository extends ReactiveCrudRepository<AbstractBaseEntity, String> {
}
