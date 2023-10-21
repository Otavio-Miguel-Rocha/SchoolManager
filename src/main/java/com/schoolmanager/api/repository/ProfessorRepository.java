package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.Professor;
import com.schoolmanager.api.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
