package com.schoolmanager.api.model;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("TEACHER")
public class Professor extends User {
    @ManyToMany
    private Classroom classroom;
    @ManyToOne
    private Discipline disciplines;

    public Professor(User user){
        super(user);
    }
}
