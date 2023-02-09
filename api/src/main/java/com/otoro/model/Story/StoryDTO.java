package com.otoro.model.Story;

import com.otoro.model.DTO;

import java.io.Serializable;
import java.util.UUID;

public class StoryDTO implements DTO, Serializable {

    private String storyId;

    private String storyTitle;

    public StoryDTO(){}

    public StoryDTO(String storyId, String storyTitle) {
        this.storyId = storyId;
        this.storyTitle = storyTitle;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    @Override
    public String toString() {
        return "StoryDTO{" +
                "storyId='" + storyId + '\'' +
                "storyTitle='" + storyTitle + '\'' +
                '}';
    }

    @Override
    public Story toTrueClass() {
        return new Story(this.storyTitle);
    }

}
