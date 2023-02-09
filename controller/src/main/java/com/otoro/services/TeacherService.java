package com.otoro.services;

import com.otoro.dao.Teacher.TeacherDAO;
import com.otoro.model.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherDAO teacherDAO;

    //inject TeacherDataAccessService
    @Autowired
    public TeacherService(@Qualifier("postgresT") TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public Teacher addTeacher(Teacher teacher){return teacherDAO.insertTeacher(teacher);}

    public List<Teacher> getAllTeacher(){return teacherDAO.selectAllTeacher();}

    public Teacher getTeacherByEmail(String email){return teacherDAO.getTeacherByEmail(email);}

    public void deleteTeacher(Teacher teacher){ teacherDAO.deleteTeacher(teacher);}

    public Teacher updateTeacher(Teacher existingTeacher, Teacher newTeacher){
        return teacherDAO.updateTeacher(existingTeacher,newTeacher);
    }

    public Teacher changePassword(Teacher existing, String newPassword){
        return teacherDAO.changePassword(existing,newPassword);
    }


}
