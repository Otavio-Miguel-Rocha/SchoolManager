package com.schoolmanager.api.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private Double grade;

    @ManyToOne
    @JsonIgnore
    private Student student;

    @ManyToOne
    private Discipline discipline;


    public Test(double grade, Student student, Discipline discipline){
        this.grade = grade;
        this.student = student;
        this.discipline = discipline;
    }
}
