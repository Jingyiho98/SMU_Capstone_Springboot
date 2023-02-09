package com.otoro.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.otoro.api.TeacherAPI;
import com.otoro.model.Teacher.Teacher;
import com.otoro.model.Teacher.TeacherDTO;
import com.otoro.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController implements TeacherAPI {

    @Autowired
    private TeacherService teacherService;

    //inject service
//    @Autowired
//    public TeacherController(TeacherService teacherService) {
//        this.teacherService = teacherService;
//    }

    @Override
    @GetMapping(value = "/getAllTeachers")
    public ResponseEntity<List<Teacher>> teacherGetAll() { return ResponseEntity.ok(teacherService.getAllTeacher()); }

    @Override
    @GetMapping(value = "/getTeacher")
    public ResponseEntity teacherGet(@RequestBody TeacherDTO teacherDTO) {
        String email = teacherDTO.getEmail();
        return ResponseEntity.ok(teacherService.getTeacherByEmail(email));
    }

    @Override
    @PostMapping(value = "/postTeacher")
    public ResponseEntity teacherPost(@RequestBody TeacherDTO teacherDTO) throws JsonProcessingException {

        String email = teacherDTO.getEmail();
//        String password = teacherDTO.getPassword();
        Teacher checkIfExist = teacherService.getTeacherByEmail(email);
        //hash password
//        String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        if (checkIfExist != null) {
            return ResponseEntity.badRequest().build();
        }

        Teacher newTeacher = teacherService.addTeacher(teacherDTO.toTrueClass());
        return ResponseEntity.ok(newTeacher);
    }

    @Override
    @DeleteMapping("/deleteTeacher")
    public ResponseEntity teacherDelete(@RequestBody TeacherDTO teacherDTO) {
        String email = teacherDTO.getEmail();
        Teacher teacherToDelete = teacherService.getTeacherByEmail(email);
        if (teacherToDelete == null){
            ResponseEntity.badRequest().build();
        }

        teacherService.deleteTeacher(teacherToDelete);
        return ResponseEntity.ok(teacherToDelete);
    }

    @Override
    public ResponseEntity teacherUpdate(@RequestBody TeacherDTO teacherDTO) throws JsonProcessingException {
        return null;
    }
}
