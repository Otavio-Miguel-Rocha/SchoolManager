package com.schoolmanager.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends User {
    @ManyToMany
    private List<Classroom> classrooms;
    @ManyToOne
    private Discipline discipline;

    public Professor(User user){
        super(user);
    }
}
