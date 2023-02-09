package com.otoro.dao.Story;



import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.model.Teacher.Teacher;

import java.util.List;

public interface StoryDAO {

    Story insertStory(Story story);

    List<Story> selectAllStories();

    Story getStoryByTitle(String storyTitle);

    Story updateStoryTitle(Story existingStory, Story newStory);

    Story addGameCode(Story currentStory, GameCode gameCode);

    Story getStoryByTitleAndUser(String storyTitle, User user);

    void deleteStory(Story storyToDelete);

   List<Story> getAllStoriesByUser(User user);


}
