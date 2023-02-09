package com.otoro.model.GameCode;

import com.otoro.model.Player.Player;
import com.otoro.model.Player.PlayerScore;
import com.otoro.model.Story.Story;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gamecode")
public class GameCode {

    @Id
    @GeneratedValue
    @Column(name = "gamecode_id")
    private Long gamecodeId;

    @Column(name = "game_code")
    private String gameCode;

    @Column(name = "comment")
    private String comment;

    //one to many r/s with player
    @OneToMany(
            mappedBy = "gameCode",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Player> players = new ArrayList<>();

    //many to one r/s with story
    @ManyToOne(fetch = FetchType.LAZY)
    private Story story;

    public GameCode() {
    }

    public GameCode(String gameCode, String comment) {
        this.gameCode = gameCode;
        this.comment = comment;
    }

    public Long getGamecodeId() {
        return gamecodeId;
    }

    public void setGamecodeId(Long gamecodeId) {
        this.gamecodeId = gamecodeId;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGameCode(this);
    }

    public void removePlayer(Player player) {
        players.remove(player);
        player.setGameCode(null);
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    @Override
    public String toString(){

        return "{ \"gameCode\":\"" + gameCode
                + "\", \"comment\":\"" + comment
                + "\", \"players\":" + this.getPlayers()
                + "}";
    }
}
