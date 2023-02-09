package com.otoro.repositories.GameCode;

import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Story.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameCodeRepository extends CrudRepository<GameCode, Long> {
    GameCode findGameCodeByGameCode(String gameCode);
    List<GameCode> findGameCodeByStory(Story story);


}