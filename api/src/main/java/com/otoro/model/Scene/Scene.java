package com.otoro.model.Scene;


import com.otoro.model.Option.Option;
import com.otoro.model.Story.Story;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "scene_info")
public class Scene {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID" ,
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "sceneID")
    private UUID sceneId;

    @Column(name = "stackNo")
    private Integer stackNo;

    @Column(name = "sceneType", columnDefinition="TEXT")
    private String sceneType;

    @Column(name = "sceneTitle" , columnDefinition="TEXT")
    private String sceneTitle;

    @Column(name = "backgroundImage", columnDefinition="TEXT")
    private String backgroundImage;

    @Column(name = "characterName", columnDefinition="TEXT")
    private String characterName;

    @Column(name = "characterImage", columnDefinition="TEXT")
    private String characterImage;

    @Column(name = "graphType", columnDefinition="TEXT")
    private String graphType;

    @Column(name = "graphImage", columnDefinition="TEXT")
    private String graphImage;

    @Column(name = "graphData", columnDefinition="TEXT")
    private String graphData;

    @Column(name = "description" , columnDefinition="TEXT")
    private String description;



    //many to one r/s with story
    @ManyToOne(fetch = FetchType.LAZY)
    private Story storys;

    @OneToMany(
            mappedBy = "scene",
            cascade = CascadeType.ALL
//            orphanRemoval = true
    )
    private List<Option> options = new ArrayList<>();


    public Scene(){ }

    public Scene(Integer stackNo, String sceneType,String sceneTitle,
                 String backgroundImage, String characterName, String characterImage,String graphType,
                 String graphImage, String graphData, String description) {
        this.stackNo = stackNo;
        this.sceneType = sceneType;
        this.sceneTitle = sceneTitle;
        this.backgroundImage = backgroundImage;
        this.characterName = characterName;
        this.characterImage = characterImage;
        this.graphType = graphType;
        this.graphImage = graphImage;
        this.graphData = graphData;
        this.description = description;

    }


    public UUID getSceneId() {
        return sceneId;
    }
    public void setSceneId(UUID sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getStackNo() {
        return stackNo;
    }

    public void setStackNo(Integer stackNo) {
        this.stackNo = stackNo;
    }

    public String getSceneType() {
        return sceneType;
    }

    public void setSceneType(String field) {
        this.sceneType = sceneType;
    }

    public String getSceneTitle() {
        return sceneTitle;
    }

    public void setSceneTitle(String sceneTitle) {
        this.sceneTitle = sceneTitle;
    }

    public String getGraphType() {
        return graphType;
    }

    public void setGraphType(String graphType) {
        this.graphType = graphType;
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    // r/s with story

    public Story getStorys() {
        return storys;
    }

    public void setStorys(Story storys) {
        this.storys = storys;
    }

    // r/s with option

    public void addOption(Option option) {
        options.add(option);
        option.setScene(this);
    }

    public void removeOption(Option option) {
        options.remove(option);
        option.setScene(null);
    }

    @Override
    public String toString(){
        return "{ \"sceneId\":\"" + sceneId
                + "\", \"stackNo\":\"" + stackNo
                + "\", \"sceneType\":\"" + sceneType
                + "\", \"sceneTitle\":\"" + sceneTitle
                + "\", \"backgroundImage\":\"" + backgroundImage
                + "\", \"characterName\":\"" + characterName
                + "\", \"characterImage\":\"" + characterImage
                + "\", \"graphType\":\"" + graphType
                + "\", \"graphImage\":\"" + graphImage
                + "\", \"graphData\":\"" + graphData
                + "\", \"description\":\"" + description
                + "\", \"options\":" + options
                + "}";
    }



}
