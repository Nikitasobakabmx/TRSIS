package com.laba.two.restfull.repositories;

import com.laba.two.restfull.model.KeyForGameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyForGameRepository extends CrudRepository<KeyForGameEntity, Integer> {
}
