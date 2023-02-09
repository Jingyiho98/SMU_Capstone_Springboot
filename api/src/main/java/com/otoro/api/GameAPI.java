package com.otoro.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.model.Game.GameDTO;
import com.otoro.model.Teacher.Teacher;
import com.otoro.model.Teacher.TeacherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GameAPI {

    ResponseEntity gameResultGet(
            @RequestParam String playerId
    );

    ResponseEntity getAllStudentGameResult();

    ResponseEntity gameResultPost(
            GameDTO gameDTO
    ) throws JsonProcessingException;


    ResponseEntity gameResultUpdate(
            GameDTO gameDTO
    ) throws JsonProcessingException;
}
