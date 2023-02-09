package com.otoro.dao.Game;

import com.otoro.model.Game.Game;
import com.otoro.model.Teacher.Teacher;
import com.otoro.repositories.Game.GameRepository;
import com.otoro.repositories.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresGame")
public class PostgresGameDataAccessService implements GameDAO{

    private GameRepository gameRepository;

    @Autowired
    public PostgresGameDataAccessService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game insertGame(Game game) { return gameRepository.save(game); }

    @Override
    public List<Game> selectAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach((games::add));
        return games;
    }

//    @Override
//    public Game getGameByPlayerId(String playerId) { return gameRepository.findStoryByPlayerId(playerId);}

}
