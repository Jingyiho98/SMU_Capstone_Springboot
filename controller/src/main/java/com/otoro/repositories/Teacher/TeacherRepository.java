package com.otoro.repositories.Teacher;

import com.otoro.model.Teacher.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
    Teacher findTeacherByEmail(String email);
}

