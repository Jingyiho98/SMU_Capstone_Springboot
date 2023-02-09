package com.otoro.model.Player;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "player_score")
//@TypeDef(
//        name = "hstore", typeClass = PostgreSQLHStoreType.class
//)
public class PlayerScore {

    @Id
    @GeneratedValue
    @Column(name = "score_id")
    private Long scoreId;

    @Column(name = "attribute_Name")
    private String attributeName;

    @Column(name = "score")
    private Integer score;

//    @Type(type = "hstore")
//    @Column(name = "player_score", columnDefinition = "hstore")
//    private Map<String,String> playerScores = new HashMap<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;



    public PlayerScore() {
    }

    public PlayerScore(String attributeName, Integer score) {
        this.attributeName = attributeName;
        this.score = score;
    }

    public PlayerScore(@NotNull UUID scoreId, String attributeName, Integer score) {
        this.attributeName = attributeName;
        this.score = score;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString(){

        return "{ \"attributeName\":\"" + attributeName
                + "\", \"score\":" + score
                + "}";
    }
}
