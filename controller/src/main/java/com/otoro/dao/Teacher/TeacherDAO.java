package com.otoro.dao.Teacher;

import com.otoro.model.Teacher.Teacher;

import java.util.List;

public interface TeacherDAO {

    Teacher insertTeacher(Teacher teacher);

    List<Teacher> selectAllTeacher();

    Teacher getTeacherByEmail(String email);

    void deleteTeacher(Teacher teacherToDelete);

    Teacher updateTeacher(Teacher existingTeacher, Teacher newTeacher);

    Teacher changePassword(Teacher existing, String newPassword);

}
