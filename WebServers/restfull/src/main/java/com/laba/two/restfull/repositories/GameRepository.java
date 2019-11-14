package com.laba.two.restfull.repositories;

import com.laba.two.restfull.model.GamesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GamesEntity, Long> {
}
