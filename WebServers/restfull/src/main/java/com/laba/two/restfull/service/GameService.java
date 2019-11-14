package com.laba.two.restfull.service;

import com.laba.two.restfull.model.GamesEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public interface GameService {
    Iterable<GamesEntity> findAll();
    void delete(GamesEntity game);
    void deleteById(String id);
    Optional<GamesEntity> findById(String id);
    GamesEntity update(GamesEntity game);
    void append(GamesEntity game);

}
