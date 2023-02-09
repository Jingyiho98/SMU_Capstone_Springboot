package com.otoro.services;

import com.otoro.dao.Game.GameDAO;
import com.otoro.model.Game.Game;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameDAO gameDAO;

    @Autowired
    public GameService(@Qualifier("postgresGame") GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    public Game addGame(Game game){return gameDAO.insertGame(game);}

    public List<Game> getAllGames(){return gameDAO.selectAllGames();}

//    public Game getGameByPlayerId(String playerId){return gameDAO.getGameByPlayerId(playerId);}

//    public Game updateGame(Game existingGame, Game newGame){return gameDAO.updateGame(existingGame,newGame);}


}
