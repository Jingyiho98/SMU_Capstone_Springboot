package com.otoro.controllers;


import com.otoro.model.Attribute.Attribute;
import com.otoro.model.Consequences.Consequences;
import com.otoro.model.Option.Option;
import com.otoro.model.Player.PlayerScore;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.services.AttributeService;
import com.otoro.services.SceneService;
import com.otoro.services.Security.UserDetailsImpl;
import com.otoro.services.Security.UserDetailsServiceImpl;
import com.otoro.services.StoryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/test")
@RestController
public class CreatingStoryController {

    @Autowired
    private SceneService sceneService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserDetailsServiceImpl userService;


    @PostMapping(value = "/postScenes")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity postScenes(@RequestBody String json) {
        JSONObject reqObj = new JSONObject(json);
        String storyTitle = (String) reqObj.get("storyTitle");
        JSONArray sceneList =  reqObj.getJSONArray("scenes");
        JSONArray attributeList = reqObj.getJSONArray("attributes");
        Integer userId =  reqObj.getInt("userId");

        if (storyTitle == null || sceneList == null || attributeList == null || userId == null){
            ResponseEntity.badRequest().body("Missing storyTitle, sceneList, attributeList, userId");
        }
        //cg need to send user id over
        //create service get user by id to get user,
        User thisUser = userService.getUserById(Long.valueOf(userId));

        //get story by title and user id!
        Story thisStory = storyService.getStoryByTitleAndUser(storyTitle,thisUser);
        if (thisStory == null) {
            //set user before adding story
            thisStory = new Story(storyTitle);
            thisStory.setUser(thisUser);
            storyService.addStory(thisStory);
        }

        List<Attribute> currentAttributes = thisStory.getAttributes();
        List<Attribute> cloned_attributes = new ArrayList<Attribute>(currentAttributes);
        int sizeAttribute = cloned_attributes.size();

        // remove existing attribute first
        if (sizeAttribute > 0){
            for (int number = 0 ; number < sizeAttribute; number++){
                Attribute toRemoveAttribute = cloned_attributes.get(number);
                thisStory.removeAttribute(toRemoveAttribute);
            }
        }




        //add attributes
        for (int i = 0; i < attributeList.length(); i++) {
            JSONObject attributeData = attributeList.getJSONObject(i);
            String attributeName = (String) attributeData.get("attributeName");
            String attributeImage = "attributeImage";

            Integer winningScore = (Integer) attributeData.get("winningScore");
            String attributeDescription = (String) attributeData.get("attributeDescription");

            if (attributeData == null || attributeName == null || winningScore == null || attributeDescription == null){
                ResponseEntity.badRequest().body("Missing attribute data, name, winningscore, or description");
            }

            Attribute thisAttribute = new Attribute(attributeName,attributeImage, winningScore,attributeDescription);
            thisStory.addAttribute(thisAttribute);

        }


        List<Scene> currentScenes = thisStory.getScenes();

        // Clone the list
        List<Scene> cloned_list = new ArrayList<Scene>(currentScenes);
//        System.out.println(currentScenes.toString());

        System.out.println("size" + currentScenes.size());
        int size = cloned_list.size();

        if (cloned_list.size() > 0){
            for (int number = 0 ; number < size; number++){
                System.out.println(number);
                Scene thisScene = cloned_list.get(number);
                Integer stackNo = thisScene.getStackNo();
                Scene toRemove = sceneService.getSceneByStackNoAndStory(stackNo,thisStory);
                thisStory.removeScene(toRemove);
            }
        }

//        storyService.addStory(thisStory);

//        if (currentScenes.toArray().length == 0){
//            return ResponseEntity.ok(currentScenes.toString());
//        }

        //empty scenes first
//        thisStory.setScenes(new ArrayList<>());
//
//        if(sceneList.length() == 0){
//            ResponseEntity.badRequest().build();
//        }

           for (int i = 0; i < sceneList.length(); i++) {
               JSONObject objects = sceneList.getJSONObject(i);
               Integer stackNo = (Integer) objects.get("stackNo");
               String sceneType = (String) objects.get("sceneType");
               String sceneTitle = (String) objects.get("sceneTitle");
               String backgroundImage = (String) objects.get("backgroundImage");
               String characterName = (String) objects.get("characterName");
               String characterImage = (String) objects.get("characterImage");
               // error checking
               String graphType = (String) objects.get("graphType");
               String graphImage = (String) objects.get("graphImage");
               String graphData = (String) objects.get("graphData");
               String description = (String) objects.get("description");

               if (stackNo == null || sceneType == null || sceneTitle == null || backgroundImage == null || characterName == null ||
                       characterImage == null || graphType == null || graphData == null ||
                       description == null ){
                   ResponseEntity.badRequest().body("Missing scenes attributes...");
               }

                //create scene to add option
               Scene thisScene = new Scene(stackNo, sceneType,sceneTitle, backgroundImage,
                       characterName, characterImage,graphType, graphImage, graphData, description);

               //get option jsonarray, loop through and add to scene
               JSONArray options =  objects.getJSONArray("options");
               if (options.length() != 0){
               for (int x = 0; x < options.length(); x++) {
                   JSONObject optionInArray = options.getJSONObject(x);
                   String optionName = (String) optionInArray.get("optionName");
                   String impactScene = (String) optionInArray.get("impactScene");
                   if (optionName == null || impactScene == null){
                       ResponseEntity.badRequest().body("Missing option name or impact scene");
                   }

                   Option thisOption = new Option(optionName,impactScene);
//                   Option thisOption = new Option(optionName,impactScene);
                   JSONArray consequencesList = optionInArray.getJSONArray("consequences");

                   //loop through jsonarray and add in consequences for thisOption.
                   for (int y = 0; y < consequencesList.length(); y++) {
                       JSONObject consequence = consequencesList.getJSONObject(y);
                       String attributeNameForConsequence = (String) consequence.get("attributeName");
                       Integer effect = (Integer) consequence.get("effect");

                       if (attributeNameForConsequence == null || effect == null){
                           ResponseEntity.badRequest().body("Missing consequences or effect");
                       }
                       thisOption.addConsequence(new Consequences(attributeNameForConsequence,effect));
                   }
                   //add option to scenes
                   thisScene.addOption(thisOption);
               }

               }

                //if story has scenes, get the scene
               // if scene exist, remove the scene
//               if (!thisStory.getScenes().isEmpty()) {
//                   //check by stackNo and StoryId so stackNo not duplicated
//                   Scene toRemove = sceneService.getSceneByStackNoAndStory(stackNo,thisStory);
//                   if (toRemove != null) {
//                       thisStory.removeScene(toRemove);
//                   }
//
//               }
               thisStory.addScene(thisScene);

//               thisStory.addScene(new Scene(sceneNo, field, backgroundImage,
//                       characterName, characterImage, graphImage, graphData, description));
           }

        storyService.addStory(thisStory);
        return ResponseEntity.ok("Scenes successfully posted");
//        return new ResponseEntity("Scenes successful result",
//                HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteScenes")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity deleteStory(@RequestParam String storyTitle, Integer userId) {
        User thisUser = userService.getUserById(Long.valueOf(userId));

        //get story by title and user id!
        Story thisStory = storyService.getStoryByTitleAndUser(storyTitle,thisUser);

        List<Attribute> currentAttributes = thisStory.getAttributes();
        List<Attribute> cloned_attributes = new ArrayList<Attribute>(currentAttributes);
        int sizeAttribute = cloned_attributes.size();

        // remove existing attribute first
        if (sizeAttribute > 0){
            for (int number = 0 ; number < sizeAttribute; number++){
                Attribute toRemoveAttribute = cloned_attributes.get(number);
                thisStory.removeAttribute(toRemoveAttribute);
            }
        }

        List<Scene> currentScenes = thisStory.getScenes();

        // Clone the list
        List<Scene> cloned_list = new ArrayList<Scene>(currentScenes);
//        System.out.println(currentScenes.toString());

        System.out.println("size" + currentScenes.size());
        int size = cloned_list.size();

        if (cloned_list.size() > 0){
            for (int number = 0 ; number < size; number++){
                System.out.println(number);
                Scene thisScene = cloned_list.get(number);
                Integer stackNo = thisScene.getStackNo();
                Scene toRemove = sceneService.getSceneByStackNoAndStory(stackNo,thisStory);
                thisStory.removeScene(toRemove);
            }
        }

        storyService.deleteStory(thisStory);
        return ResponseEntity.ok("Scenes successfully deleted");



    }




}
