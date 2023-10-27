package com.schoolmanager.api.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(length = 15, unique = true, nullable = false)
    private String className;

    @ManyToMany(mappedBy = "classrooms")
    private List<Professor> professors;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private List<Student> students;
}
