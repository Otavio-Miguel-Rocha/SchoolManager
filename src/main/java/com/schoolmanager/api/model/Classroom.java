package com.schoolmanager.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "classname", length = 15, unique = true)
    private String className;

    @OneToMany(mappedBy = "classrooms")
    private List<Professor> professors;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;
}
