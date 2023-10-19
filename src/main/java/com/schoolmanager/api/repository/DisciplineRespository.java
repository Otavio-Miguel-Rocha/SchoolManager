package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRespository extends JpaRepository<Discipline, Integer> {
}
