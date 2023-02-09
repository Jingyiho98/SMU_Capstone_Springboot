package com.otoro.model.Player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.otoro.model.GameCode.GameCode;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "player")
//@TypeDef(
//        name = "hstore", typeClass = PostgreSQLHStoreType.class
//)
public class Player {
    //column creation
    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID" ,
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "player_name")
    private String playerName;

    //one to many r/s with playerscores
    @OneToMany(
            mappedBy = "player",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayerScore> playerScores = new ArrayList<>();

    //many to one r/s with gamecode
    @ManyToOne(fetch = FetchType.LAZY)
    private GameCode gameCode;


//    @Type(type = "hstore")
//    @Column(name = "player_score", columnDefinition = "hstore")
//    private Map<String,String> playerScores = new HashMap<>();

    public Player() {
    }

    public Player(@NotNull UUID playerId, String playerName) {
        this.playerName = playerName;
    }

    public Player(@NotNull UUID playerId, String playerName, List<PlayerScore> playerScores) {
        this.playerName = playerName;
        this.playerScores = playerScores;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    public GameCode getGameCode() {
        return gameCode;
    }

    public void setGameCode(GameCode gameCode) {
        this.gameCode = gameCode;
    }

    public void addComment(PlayerScore playerScore) {
        playerScores.add(playerScore);
        playerScore.setPlayer(this);
    }

    public void removeComment(PlayerScore playerScore) {
        playerScores.remove(playerScore);
        playerScore.setPlayer(null);
    }


    //to send back lol
    @Override
    public String toString(){

        return "{ \"playerName\":\"" + playerName
                + "\", \"playerScore\":" + this.getPlayerScores()
                + "}";
    }
}
