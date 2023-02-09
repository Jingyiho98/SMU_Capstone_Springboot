package com.otoro.dao.Player;

import com.otoro.model.Player.Player;
import com.otoro.model.Teacher.Teacher;
import com.otoro.repositories.Player.PlayerRepository;
import com.otoro.repositories.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresPlayer")
public class PostgresPlayerDataAccessService implements PlayerDAO {

    private PlayerRepository playerRepository;

    @Autowired
    public PostgresPlayerDataAccessService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player insertPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> selectAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach((players::add));
        return players;
    }
}
