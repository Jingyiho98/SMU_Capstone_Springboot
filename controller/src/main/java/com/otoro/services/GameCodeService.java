package com.otoro.services;

import com.otoro.dao.Game.GameDAO;
import com.otoro.dao.GameCode.GameCodeDAO;
import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Story.Story;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameCodeService {
    private final GameCodeDAO gameCodeDAO;

    @Autowired
    public GameCodeService(@Qualifier("postgresGameCode") GameCodeDAO gameCodeDAO) {
        this.gameCodeDAO = gameCodeDAO;
    }

    public GameCode addGameCode(GameCode gameCode){return gameCodeDAO.insertGameCode(gameCode);}

    public List<GameCode> getAllGameCodes(){return gameCodeDAO.selectAllCodes();}

    public GameCode getGameCodeByCode(String code){return gameCodeDAO.getGameCodeByCode(code);}

    public List<GameCode> getGameCodeByStory(Story story){return gameCodeDAO.getGameCodeByStory(story);}


}
