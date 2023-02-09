package com.otoro.controllers;

import com.otoro.model.Game.Game;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Player.Player;
import com.otoro.model.Player.PlayerScore;
import com.otoro.model.Security.User;
import com.otoro.model.Story.Story;
import com.otoro.services.GameCodeService;
import com.otoro.services.GameService;
import com.otoro.services.PlayerService;
import com.otoro.services.Security.UserDetailsServiceImpl;
import com.otoro.services.StoryService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class GameCodeController {

    @Autowired
    private GameCodeService gameCodeService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserDetailsServiceImpl userService;


    @GetMapping(value = "/createGetCodeNow")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> createGetCode(@RequestParam String storyTitle, String comment, Integer userId) {
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
        GameCode newGameCode = new GameCode(sb.toString(),comment);


        User thisUser = userService.getUserById(Long.valueOf(userId));

        Story currentStory = storyService.getStoryByTitleAndUser(storyTitle,thisUser);

        //error check whether currentStory is null
        if (currentStory == null){
            return ResponseEntity.badRequest().build();
        }

        storyService.addGameCode(currentStory,newGameCode);


        return ResponseEntity.ok(sb.toString());
    }

    @GetMapping(value = "/getStoryByCode")
    public ResponseEntity<?> getStoryByCode(@RequestParam String gameCode) {
        GameCode thisGameCode = gameCodeService.getGameCodeByCode(gameCode);


        if (thisGameCode == null){
            return ResponseEntity.badRequest().build();
        }

        Story story = thisGameCode.getStory();

        return ResponseEntity.ok(story.toString());

    }


    @GetMapping(value = "/getAllCodes")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getAllCodes() {
        return ResponseEntity.ok(gameCodeService.getAllGameCodes().toString());
    }

    @GetMapping(value = "/getResultsByCode")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getResultByCode(@RequestParam String code) {
        GameCode currentGameCode = gameCodeService.getGameCodeByCode(code);
        return ResponseEntity.ok(currentGameCode.toString());
    }

    @PostMapping(value = "/postPlayersAndResults")
    @PreAuthorize("permitAll()")
    public ResponseEntity playerScorePost(@RequestBody String json) {
        JSONObject reqObj = new JSONObject(json);
        String code = (String) reqObj.get("gameCode");
        String name = (String) reqObj.get("playerName");
        JSONArray playerScores =  reqObj.getJSONArray("playerScores");

        Player newPlayer = new Player(UUID.randomUUID(),name);


        for(int i = 0; i < playerScores.length(); i++)
        {
            JSONObject objects = playerScores.getJSONObject(i);
            String attributeName = (String) objects.get("attributeName");
            Integer score = (Integer) objects.get("score");

            newPlayer.addComment(new PlayerScore(attributeName,score));
            //pls change ^method name
        }

        GameCode currentGameCode = gameCodeService.getGameCodeByCode(code);
        currentGameCode.addPlayer(newPlayer);

        //update gamecode with newPlayer results
        gameCodeService.addGameCode(currentGameCode);
        return ResponseEntity.ok("Successfully Posted Result");

        //do some things with json, put some header information in json

    }

    @GetMapping(value = "/getAllCodesByStory")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllCodesByStory(@RequestParam String storyTitle, Integer userId){

        User thisUser = userService.getUserById(Long.valueOf(userId));
        Story thisStory = storyService.getStoryByTitleAndUser(storyTitle,thisUser);
        List<GameCode> allGameCodes = gameCodeService.getGameCodeByStory(thisStory);
        Map<String,String> gameCodes = new HashMap<>();
        for(GameCode gameCode: allGameCodes) {
            gameCodes.put(gameCode.getGameCode(),gameCode.getComment());
        }

        return ResponseEntity.ok(gameCodes);
    }

}
