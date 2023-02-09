package com.otoro.repositories.Scene;

import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SceneRepository extends CrudRepository<Scene, UUID> {
    Scene findSceneByStackNo(Integer stackNo);
    Scene findSceneByStackNoAndStorys(Integer stackNo, Story storys);
}
