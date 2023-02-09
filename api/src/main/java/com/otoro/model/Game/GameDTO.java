package com.otoro.model.Game;

import com.otoro.model.DTO;

import java.io.Serializable;
import java.util.UUID;

public class GameDTO implements DTO, Serializable {

    private String gameCodeId;

    public GameDTO() {
    }

    public GameDTO(String gameCodeId) {
        this.gameCodeId = gameCodeId;

    }

    public String getGameCodeId() {
        return gameCodeId;
    }

    public void setGameCodeId(String gameCodeId) {
        this.gameCodeId = gameCodeId;
    }


    @Override
    public String toString() {
        return "GameDTO{" +
                "gameCodeId='" + gameCodeId + '\'' +
                '}';
    }

    @Override
    public Game toTrueClass() {
        return new Game(UUID.randomUUID(),this.gameCodeId);
    }

}
