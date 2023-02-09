package com.otoro.controllers;


import com.otoro.api.PlayerAPI;
import com.otoro.model.Player.Player;
import com.otoro.model.Player.PlayerScore;
import com.otoro.services.PlayerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PlayerController implements PlayerAPI {

    @Autowired
    private PlayerService playerService;

    @Override
    @GetMapping(value = "/getAllPlayerResults")
    public ResponseEntity<?> getAllPlayersScore() {
        return ResponseEntity.ok(playerService.getAllPlayer().toString());
    }

    @Override
    @PostMapping(value = "/postResult")
    public ResponseEntity playerScorePost(@RequestBody String json) {
        JSONObject reqObj = new JSONObject(json);
        String name = (String) reqObj.get("playerName");
        JSONArray playerScores =  reqObj.getJSONArray("playerScores");

        Player newPlayer = new Player(UUID.randomUUID(),name);

        for(int i = 0; i < playerScores.length(); i++)
        {
            JSONObject objects = playerScores.getJSONObject(i);
            String attributeName = (String) objects.get("attributeName");
            Integer score = (Integer) objects.get("score");

            newPlayer.addComment(new PlayerScore(attributeName,score));
        }



        playerService.insertPlayer(newPlayer);
        return ResponseEntity.ok("Successfully Posted Result");

        //do some things with json, put some header information in json

    }

}
