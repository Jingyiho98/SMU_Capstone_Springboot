package com.otoro.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface PlayerAPI {

    ResponseEntity getAllPlayersScore();

    ResponseEntity playerScorePost(
            String json
    ) throws JsonProcessingException;

}
