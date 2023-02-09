package com.otoro.services;

import com.otoro.dao.Player.PlayerDAO;
import com.otoro.dao.Teacher.TeacherDAO;
import com.otoro.model.Player.Player;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerDAO playerDAO;

    @Autowired
    public PlayerService(@Qualifier("postgresPlayer") PlayerDAO playerDAO) {
            this.playerDAO = playerDAO;
        }

    public Player insertPlayer(Player player){return playerDAO.insertPlayer(player);}

    public List<Player> getAllPlayer(){return playerDAO.selectAllPlayers();}


    }
