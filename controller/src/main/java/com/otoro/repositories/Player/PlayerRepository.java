package com.otoro.repositories.Player;

import com.otoro.model.Player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlayerRepository extends CrudRepository<Player, UUID> {

}
