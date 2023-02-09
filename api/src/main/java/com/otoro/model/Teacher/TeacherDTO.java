package com.otoro.model.Teacher;


import com.otoro.model.DTO;

import java.io.Serializable;
import java.util.UUID;

public class TeacherDTO implements DTO, Serializable{
    private String email;
    private String password;

    public TeacherDTO() {
    }

    public TeacherDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public Teacher toTrueClass(){ return new Teacher(UUID.randomUUID(), this.email, this.password);}

}
