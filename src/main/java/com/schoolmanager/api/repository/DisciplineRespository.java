package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRespository extends JpaRepository<Discipline, Integer> {
}
