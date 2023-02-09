package com.otoro.dao.Scene;


import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;
import com.otoro.repositories.Scene.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresScene")
public class PostgresSceneDataAccessService implements SceneDAO{

    private SceneRepository sceneRepository;

    @Autowired
    public PostgresSceneDataAccessService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }

    @Override
    public Scene insertScene(Scene scene) { return sceneRepository.save(scene); }

    @Override
    public List<Scene> selectAllScenes() {
        List<Scene> scenes = new ArrayList<>();
        sceneRepository.findAll().forEach((scenes::add));
        return scenes;
    }

    @Override
    public Scene getSceneByStackNo(Integer stackNo) { return sceneRepository.findSceneByStackNo(stackNo); }

    @Override
    public void deleteScene(Scene sceneToDelete) { sceneRepository.delete(sceneToDelete);}

    @Override
    public Scene updateScene(Scene existingScene, Scene newScene) {
        existingScene.setSceneType(newScene.getSceneType());
        existingScene.setBackgroundImage(newScene.getBackgroundImage());
        existingScene.setCharacterImage(newScene.getCharacterImage());
        existingScene.setCharacterName(newScene.getCharacterName());
        existingScene.setGraphImage(newScene.getGraphImage());
        existingScene.setDescription(newScene.getDescription());
        return sceneRepository.save(existingScene);
    }

    @Override
    public Scene getSceneByStackNoAndStory(Integer stackNo, Story story){ return sceneRepository.findSceneByStackNoAndStorys(stackNo, story);}
}
