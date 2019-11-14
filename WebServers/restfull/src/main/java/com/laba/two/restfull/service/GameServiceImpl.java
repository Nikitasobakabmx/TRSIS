package com.laba.two.restfull.service;

import com.laba.two.restfull.model.GamesEntity;
import com.laba.two.restfull.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;


    @Override
    public Iterable<GamesEntity> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(GamesEntity game){
        gameRepository.delete(game);
    }

    @Override
    public void deleteById(String id) {
        gameRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Optional<GamesEntity> findById(String id) {
        return gameRepository.findById(Long.parseLong(id));
    }

    @Override
    public GamesEntity update(GamesEntity game) {
        Optional<GamesEntity> tmp = gameRepository.findById(game.getId());
        GamesEntity oneTmp = tmp.get();
        oneTmp = merge(oneTmp, game);
        gameRepository.save(oneTmp);
        return oneTmp;
    }

    private GamesEntity merge(GamesEntity original, GamesEntity badCopy){
        if(original == null)
            throw new NullPointerException("Vot Eblan!");
        if (badCopy.getCost() != null)
            original.setCost(badCopy.getCost());
        if (badCopy.getName() != null)
            original.setName(badCopy.getName());
        if (badCopy.getStudioName() != null)
            original.setStudioName(badCopy.getStudioName());
        if (badCopy.getDescription() != null)
            original.setDescription(badCopy.getDescription());
        if (badCopy.getPhoto() != null)
            original.setPhoto(badCopy.getPhoto());
        return original;
    }
    @Override
    public void append(GamesEntity game) {
        gameRepository.save(game);
    }
}
