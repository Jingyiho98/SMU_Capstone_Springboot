package com.otoro.dao.Scene;

import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;

import java.util.List;

public interface SceneDAO {
    Scene insertScene(Scene scene);

    List<Scene> selectAllScenes();

    Scene getSceneByStackNo(Integer stackNo);

    void deleteScene(Scene sceneToDelete);

    Scene updateScene(Scene existingScene, Scene newScene);

    Scene getSceneByStackNoAndStory(Integer stackNo, Story story);
}
