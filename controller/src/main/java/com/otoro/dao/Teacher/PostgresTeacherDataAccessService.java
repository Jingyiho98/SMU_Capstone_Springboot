package com.otoro.dao.Teacher;


import com.otoro.model.Teacher.Teacher;
import com.otoro.repositories.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgresT")
public class PostgresTeacherDataAccessService implements TeacherDAO {

    private TeacherRepository teacherRepository;

    @Autowired
    public PostgresTeacherDataAccessService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher insertTeacher(Teacher teacher) { return teacherRepository.save(teacher); }

    @Override
    public List<Teacher> selectAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach((teachers::add));
        return teachers;
    }

    @Override
    public Teacher getTeacherByEmail(String email) { return teacherRepository.findTeacherByEmail(email);}

    @Override
    public void deleteTeacher(Teacher teacherToDelete) { teacherRepository.delete(teacherToDelete); }

    @Override
    public Teacher updateTeacher(Teacher existingTeacher, Teacher newTeacher) {
        existingTeacher.setEmail(newTeacher.getEmail());
        existingTeacher.setPassword(newTeacher.getPassword());
        return teacherRepository.save(existingTeacher);
    }

    @Override
    public Teacher changePassword(Teacher existingTeacher, String newPassword) {
        existingTeacher.setPassword(newPassword);
        return teacherRepository.save(existingTeacher);
    }
}
