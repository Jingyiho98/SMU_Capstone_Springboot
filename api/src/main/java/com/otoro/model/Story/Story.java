package com.otoro.model.Story;

import com.otoro.model.Attribute.Attribute;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Security.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "story_info")
public class Story {

    @Id
    @GeneratedValue
    @Column(name = "storyID")
    private Long storyId;

    @Column(name = "storyTitle")
    private String storyTitle;

    //many to one r/s with user
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //one to many r/s with gamecode
    @OneToMany(
            mappedBy = "story",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<GameCode> gameCodes = new ArrayList<>();

    @OneToMany(
            mappedBy = "storys",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Scene> scenes = new ArrayList<>();

    @OneToMany(
            mappedBy = "storya",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attribute> attributes = new ArrayList<>();

    //constructors
    public Story(){ }

    public Story( String storyTitle) {
        this.storyTitle = storyTitle;
    }


    //methods
    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

//    public Integer getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(Integer teacherId) {
//        this.teacherId = teacherId;
//    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public List<GameCode> getGameCodes() {
        return gameCodes;
    }

    public void setGameCodes(List<GameCode> gameCodes) {
        this.gameCodes = gameCodes;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    // r/s with gamecode
    public void addGameCode(GameCode gameCode) {
        gameCodes.add(gameCode);
        gameCode.setStory(this);
    }

    public void removeGameCode(GameCode gameCode) {
        gameCodes.remove(gameCode);
        gameCode.setStory(null);
    }

    // r/s with scene

    public void addScene(Scene scene) {
        scenes.add(scene);
        scene.setStorys(this);
    }

    public void removeScene(Scene scene) {
        scenes.remove(scene);
        scene.setStorys(null);
    }

    // r/s with attribute
    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
        attribute.setStorya(this);
    }

    public void removeAttribute(Attribute attribute) {
        attributes.remove(attribute);
        attribute.setStorya(null);
    }

    //r/s with user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //override toString method to return Json of Story information
    @Override
    public String toString(){
        return "{ \"storyId\":\"" + storyId
                + "\", \"storyTitle\":\"" + storyTitle
                + "\", \"attributes\":" + attributes
                + ", \"scenes\":" + scenes
                + "}";

    }



    //will have ^ more in the future when r/s is added

}
