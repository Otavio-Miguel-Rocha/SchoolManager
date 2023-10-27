package com.schoolmanager.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student extends User {
    @ManyToOne
    @JsonIgnore
    private Classroom classroom;


    @OneToMany(mappedBy = "student")
    private List<Test> tests;

    public Student(User user){
        super(user);
    }
}

