package com.otoro.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.model.Teacher.Teacher;
import com.otoro.model.Teacher.TeacherDTO;
import org.springframework.http.ResponseEntity;

public interface TeacherAPI {

    ResponseEntity teacherGetAll();

    ResponseEntity teacherGet(
            TeacherDTO teacherDTO
    );

    ResponseEntity teacherPost(
            TeacherDTO teacherDTO
    ) throws JsonProcessingException;

    ResponseEntity teacherDelete(
            TeacherDTO teacherDTO
    );

    ResponseEntity teacherUpdate(
            TeacherDTO teacherDTO
    ) throws JsonProcessingException;

}
