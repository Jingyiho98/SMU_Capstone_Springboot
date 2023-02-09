package com.otoro.services;

import com.otoro.dao.Game.GameDAO;
import com.otoro.dao.Story.StoryDAO;
import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {
    private final StoryDAO storyDAO;

    @Autowired
    public StoryService(@Qualifier("postgresStory") StoryDAO storyDAO) {
        this.storyDAO = storyDAO;
    }

    public Story addStory(Story story){ return storyDAO.insertStory(story);}

    public List<Story> getAllStories(){return storyDAO.selectAllStories();}

    public Story getStoryByTitle(String storyTitle){return storyDAO.getStoryByTitle(storyTitle);}

    public Story updateStoryTitle(Story existingStory, Story newStory){
        return storyDAO.updateStoryTitle(existingStory,newStory);
    }

    public Story getStoryByTitleAndUser(String storyTitle, User user ){return storyDAO.getStoryByTitleAndUser(storyTitle,user);}

    public List<Story> getAllStoriesByUser(User user){return storyDAO.getAllStoriesByUser(user);}

    public Story addGameCode(Story currentStory, GameCode gamecode){
        return storyDAO.addGameCode(currentStory,gamecode);
    }

    public void deleteStory(Story story){ storyDAO.deleteStory(story);}




}
