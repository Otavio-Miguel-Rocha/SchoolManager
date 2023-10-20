package com.schoolmanager.api.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
    @ManyToOne
    private Classroom classroom;


    public Student(User user){
        super(user);
    }
}

