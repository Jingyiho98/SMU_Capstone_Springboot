package com.otoro.repositories.Game;

import com.otoro.model.Game.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameRepository extends CrudRepository<Game, UUID> {
//    Game findStoryByPlayerId(String PlayerId);
}
