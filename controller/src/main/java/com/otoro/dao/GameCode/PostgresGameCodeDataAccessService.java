package com.otoro.dao.GameCode;

import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Story.Story;
import com.otoro.repositories.GameCode.GameCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresGameCode")
public class PostgresGameCodeDataAccessService implements GameCodeDAO{

    private GameCodeRepository gameCodeRepository;

    @Autowired
    public PostgresGameCodeDataAccessService(GameCodeRepository gameCodeRepository) {
        this.gameCodeRepository = gameCodeRepository;
    }

    @Override
    public GameCode insertGameCode(GameCode gameCode) {
        return gameCodeRepository.save(gameCode);
    }

    @Override
    public List<GameCode> selectAllCodes() {
        List<GameCode> gamecodes = new ArrayList<>();
        gameCodeRepository.findAll().forEach((gamecodes::add));
        return gamecodes;
    }

    @Override
    public GameCode getGameCodeByCode(String code) {
        return gameCodeRepository.findGameCodeByGameCode(code);
    }

    public List<GameCode> getGameCodeByStory(Story story) {
        return gameCodeRepository.findGameCodeByStory(story);
    }
}
