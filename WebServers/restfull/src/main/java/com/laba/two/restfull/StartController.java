package com.laba.two.restfull;

import com.laba.two.restfull.model.GamesEntity;
import com.laba.two.restfull.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/")
class StartController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> get(@RequestParam(value = "id", defaultValue = "null") String id){
        if(!id.equals("null"))
            return ResponseEntity.ok(gameService.findById(id));
        return ResponseEntity.ok(gameService.findAll());
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam(value = "id") String id){
        Optional<GamesEntity> tmp = gameService.findById(id);
        gameService.deleteById(id);
        return ResponseEntity.ok(tmp);
    }
    @RequestMapping(method=RequestMethod.POST, consumes = "application/json", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<Object> append(@RequestBody GamesEntity entity){
        gameService.append(entity);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody ResponseEntity<Object> update(@RequestBody GamesEntity entity){
        GamesEntity tmp = gameService.update(entity);
        return ResponseEntity.ok(tmp);
    }

}

