package com.otoro.repositories.Story;

import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends CrudRepository<Story, String> {
    Story findStoryByStoryTitle(String storyTitle);
    Story findStoryByStoryTitleAndUser(String storyTitle, User user);
    List<Story> findStoriesByUser(User user);
}
