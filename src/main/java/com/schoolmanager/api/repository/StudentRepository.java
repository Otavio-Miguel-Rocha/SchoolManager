package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
