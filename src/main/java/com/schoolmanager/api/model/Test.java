package com.schoolmanager.api.model;

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
    private Integer id;

    private Double grade;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Discipline discipline;


    public Test(double grade, Student student, Discipline discipline){
        this.grade = grade;
        this.student = student;
        this.discipline = discipline;
    }
}
