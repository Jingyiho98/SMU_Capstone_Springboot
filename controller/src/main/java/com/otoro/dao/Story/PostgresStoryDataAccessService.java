package com.otoro.dao.Story;

import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.repositories.Game.GameRepository;
import com.otoro.repositories.Story.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.otoro.model.GameCode.GameCode;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresStory")
public class PostgresStoryDataAccessService implements StoryDAO{

    private StoryRepository storyRepository;

    @Autowired
    public PostgresStoryDataAccessService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }


    @Override
    public Story insertStory(Story story) { return storyRepository.save(story); }

    @Override
    public List<Story> selectAllStories() {
        List<Story> stories = new ArrayList<>();
        storyRepository.findAll().forEach((stories::add));
        return stories;
    }

    @Override
    public Story getStoryByTitle(String storyTitle) {  return storyRepository.findStoryByStoryTitle(storyTitle); }


    @Override
    public Story updateStoryTitle(Story existingStory, Story newStory) {
        existingStory.setStoryTitle(newStory.getStoryTitle());
        return storyRepository.save(existingStory);
    }


    @Override
    public Story addGameCode(Story currentStory, GameCode gamecode) {
        String storyTitle = currentStory.getStoryTitle();
        Story thisStory = storyRepository.findStoryByStoryTitle(storyTitle);
        thisStory.addGameCode(gamecode);
        return storyRepository.save(thisStory);

    }

    @Override
    public Story getStoryByTitleAndUser(String storyTitle, User user) {
        return storyRepository.findStoryByStoryTitleAndUser(storyTitle,user);
    }

    @Override
    public void deleteStory(Story storyToDelete) {
        storyRepository.delete(storyToDelete);
    }

    @Override
    public List<Story> getAllStoriesByUser(User user) {
        return storyRepository.findStoriesByUser(user);
    }
}
