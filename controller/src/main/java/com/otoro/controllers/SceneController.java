package com.otoro.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Scene.SceneDTO;
import com.otoro.model.Story.Story;
import com.otoro.services.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SceneController  {

    @Autowired
    private SceneService sceneService;


    @GetMapping(value = "/getScene")
    @PreAuthorize("permitAll()")
    public ResponseEntity sceneGet(@RequestParam Integer stackNo) {
        return ResponseEntity.ok(sceneService.getSceneByStackNo(stackNo));
    }


    @GetMapping(value = "/getAllScenes")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Scene>> getAllScenes() {
        return ResponseEntity.ok(sceneService.getAllScenes());
    }


    @PostMapping(value = "/postScene")
    public ResponseEntity scenePost(@RequestBody SceneDTO sceneDTO) throws JsonProcessingException {
        Scene newScene = sceneService.addScene(sceneDTO.toTrueClass());
        return ResponseEntity.ok(newScene);
    }


    public ResponseEntity sceneUpdate(SceneDTO sceneDTO) throws JsonProcessingException {
        return null;
    }

    public ResponseEntity sceneDelete(SceneDTO sceneDTO) {
        Integer stackNo = sceneDTO.getSceneNo();
        Scene sceneToDelete = sceneService.getSceneByStackNo(stackNo);
        if (sceneToDelete == null){
            ResponseEntity.badRequest().build();
        }

        sceneService.deleteScene(sceneToDelete);
        return ResponseEntity.ok(sceneToDelete);
    }

}
