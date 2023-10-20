package com.schoolmanager.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TEACHER")
public class Professor extends User {
    @ManyToMany
    private List<Classroom> classrooms;
    @ManyToOne
    private Discipline disciplines;

    public Professor(User user){
        super(user);
    }
}
