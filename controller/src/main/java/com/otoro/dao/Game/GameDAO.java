package com.otoro.dao.Game;

import com.otoro.model.Game.Game;

import java.util.List;

public interface GameDAO {

    Game insertGame(Game game);

    List<Game> selectAllGames();


}
