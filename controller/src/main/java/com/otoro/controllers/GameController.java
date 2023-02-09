package com.otoro.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.api.GameAPI;
import com.otoro.model.Game.Game;
import com.otoro.model.Game.GameDTO;
import com.otoro.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController implements GameAPI {

    @Autowired
    private GameService gameService;


    @Override
    @GetMapping(value = "/getGamesByID")
    public ResponseEntity gameResultGet(@RequestParam String playerId) {
        return ResponseEntity.ok("hello");
    }

    @Override
    @GetMapping(value = "/getAllGames")
    public ResponseEntity<List<Game>> getAllStudentGameResult() { return ResponseEntity.ok(gameService.getAllGames()); }

    @Override
    @PostMapping(value = "/postGame")
    public ResponseEntity gameResultPost(@RequestBody GameDTO GameDTO) throws JsonProcessingException {
        //need more error checking here, check if got same game code, same playerid
        Game newGame = gameService.addGame(GameDTO.toTrueClass());
        return ResponseEntity.ok(newGame);
    }

    @Override
    public ResponseEntity gameResultUpdate(GameDTO GameDTO) throws JsonProcessingException {
        //get game code and playerid entity from db then change it to new one , the score will be diff
        return null;
    }
}
