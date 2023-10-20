package com.schoolmanager.api.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@DiscriminatorValue("TEACHER")
public class Professor extends User {
    @ManyToMany
    private List<Classroom> classroom;
    @ManyToOne
    private Discipline disciplines;

    public Professor(User user){
        super(user);
    }
}
