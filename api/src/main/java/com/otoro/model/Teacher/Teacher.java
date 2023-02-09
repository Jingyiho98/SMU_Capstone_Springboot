package com.otoro.model.Teacher;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table(name = "teacher_info")
public class Teacher {

    //column creation
    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID" ,
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "teacher_id")
    private UUID teacherId;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password")
    private String password;

    //constructors
    public Teacher() {
    }

    public Teacher(@NotNull UUID teacherId, String email, String password){
        this.email = email;
        this.password = password;
    }

    //Getters and Setters

    public UUID getTeacherId() { return teacherId; }

    public void setTeacherId(UUID teacherId) { this.teacherId = teacherId; }

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

    //override toString method to return Json of Teacher information
    @Override
    public String toString(){
        return "{ email=" + email
                + ", password=" + password
                + "}";
    }
}
