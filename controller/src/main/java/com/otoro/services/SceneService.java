package com.otoro.services;

import com.otoro.dao.Scene.SceneDAO;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneService {
    private final SceneDAO sceneDAO;

    //inject SceneDataAccessService
    @Autowired
    public SceneService(@Qualifier("postgresScene") SceneDAO sceneDAO) {
        this.sceneDAO = sceneDAO;
    }

    public Scene addScene(Scene scene){return sceneDAO.insertScene(scene);}

    public List<Scene> getAllScenes(){return sceneDAO.selectAllScenes();}

    public Scene getSceneByStackNo(Integer stackNo){return sceneDAO.getSceneByStackNo(stackNo);}

    public void deleteScene(Scene scene){ sceneDAO.deleteScene(scene);}

    public Scene updateScene(Scene existingScene, Scene newScene){
        return sceneDAO.updateScene(existingScene,newScene);
    }

    public Scene getSceneByStackNoAndStory(Integer stackNo, Story story){return sceneDAO.getSceneByStackNoAndStory(stackNo, story);}

}
