package com.otoro.model.Scene;

import com.otoro.model.DTO;
import com.otoro.model.Game.Game;

import java.io.Serializable;
import java.util.UUID;

public class SceneDTO implements DTO, Serializable {

    private Integer stackNo;
    private String field;
    private String sceneTitle;
    private String backgroundImage;
    private String characterName;
    private String characterImage;
    private String graphType;
    private String graphImage;
    private String graphData;
    private String description;


    public SceneDTO(){}

    public SceneDTO(Integer stackNo, String field,String sceneTitle, String backgroundImage,
                    String characterName, String characterImage,String graphType, String graphImage, String graphData, String description) {
        this.stackNo = stackNo;
        this.field = field;
        this.sceneTitle = sceneTitle;
        this.backgroundImage = backgroundImage;
        this.characterName = characterName;
        this.characterImage = characterImage;
        this.graphType = graphType;
        this.graphImage = graphImage;
        this.graphData = graphData;
        this.description = description;
    }

    public Integer getSceneNo() { return stackNo; }

    public void setSceneNo(Integer stackNo) { this.stackNo = stackNo; }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(String characterImage) {
        this.characterImage = characterImage;
    }

    public String getGraphImage() {
        return graphImage;
    }

    public void setGraphImage(String graphImage) {
        this.graphImage = graphImage;
    }

    public String getGraphData() { return graphData; }

    public void setGraphData(String graphData) { this.graphData = graphData; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SceneDTO{" +
                "stackNo='" + stackNo + '\'' +
                ", field='" + field + '\'' +
                ", sceneTitle='" + sceneTitle + '\'' +
                ", backgroundImage='" + backgroundImage + '\'' +
                ", characterName='" + characterName + '\'' +
                ", characterImage='" + characterImage + '\'' +
                ", graphImage='" + graphImage + '\'' +
                ", graphData='" + graphData + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public Scene toTrueClass() {
        return new Scene(this.stackNo,this.field, this.sceneTitle,
                this.backgroundImage, this.characterName,this.characterImage,this.graphType,this.graphImage,this.graphData, this.description);
    }
}
