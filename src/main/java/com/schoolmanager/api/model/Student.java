package com.schoolmanager.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("STUDENT")
public class Student extends User {
    @ManyToOne
    private Classroom classroom;


    @OneToMany(mappedBy = "student")
    private List<Test> tests;


    public Student(User user){
        super(user);
    }
}

