package com.otoro.model.Game;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "game_info")
public class Game {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID" ,
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "gameID")
    private UUID gameId;

    @Column(name = "gameCodeID")
    private String gameCodeId;

    @Column(name = "timestamp")
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
//    private java.util.Date timestamp;
    private Date timestamp;


    public Game() {
    }

    public Game(@NotNull UUID gameId, String gameCodeId) {
        this.gameCodeId = gameCodeId;
    }

    public UUID getGameId() { return gameId; }

    public void setGameId(UUID gameId) { this.gameId = gameId; }

    public String getGameCodeId() { return gameCodeId; }

    public void setGameCodeId(String gameCodeId) { this.gameCodeId = gameCodeId; }

    public Date getTimestamp() { return timestamp; }

    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }



    //override toString method to return Json of Game information
    @Override
    public String toString(){
        return "{ gameId=" + gameId
                + ", gameCodeId=" + gameCodeId
                + ", timestamp=" + timestamp
                + "}";
    }
}
