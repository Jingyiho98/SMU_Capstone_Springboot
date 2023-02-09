package com.otoro.dao.GameCode;

import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Story.Story;
import com.otoro.model.Teacher.Teacher;

import java.util.List;

public interface GameCodeDAO {

    GameCode insertGameCode(GameCode gameCode);

    List<GameCode> selectAllCodes();

    GameCode getGameCodeByCode(String code);

    List<GameCode> getGameCodeByStory(Story story);

}
