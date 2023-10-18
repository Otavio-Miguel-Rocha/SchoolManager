package com.schoolmanager.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "classname", length = 15, unique = true)
    private String className;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private User professor;

    // Getters and setters
}
