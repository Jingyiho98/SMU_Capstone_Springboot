package com.otoro.dao.Player;


import com.otoro.model.Player.Player;
import com.otoro.model.Teacher.Teacher;

import java.util.List;

public interface PlayerDAO {

    Player insertPlayer(Player player);

    List<Player> selectAllPlayers();

    //getplayersbygamecode
}
