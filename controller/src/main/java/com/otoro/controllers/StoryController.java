package com.otoro.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.model.Story.StoryDTO;
import com.otoro.model.Teacher.Teacher;
import com.otoro.services.Security.UserDetailsServiceImpl;
import com.otoro.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/test")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserDetailsServiceImpl userService;

    //need inject teacher service in as well.



    @GetMapping(value = "/getStoryByTitle")
    @PreAuthorize("permitAll()")
    public ResponseEntity storyGet(@RequestBody StoryDTO storyDTO) {
        String title = storyDTO.getStoryTitle();
        return ResponseEntity.ok(storyService.getStoryByTitle(title));
    }


    @GetMapping(value = "/getAllStories")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllStory(@RequestParam Integer userId) {
        User thisUser = userService.getUserById(Long.valueOf(userId));
        return ResponseEntity.ok(storyService.getAllStoriesByUser(thisUser).toString());
    }


    @PostMapping(value = "/postStory")
    @PreAuthorize("permitAll()")
    public ResponseEntity storyPost(@RequestBody StoryDTO storyDTO) throws JsonProcessingException {
        //error checking pls
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        storyDTO.setStoryId(sb.toString());
        return ResponseEntity.ok(storyService.addStory(storyDTO.toTrueClass()));
    }


    public ResponseEntity storyUpdate(StoryDTO storyDTO) throws JsonProcessingException {
        return null;
    }
}
