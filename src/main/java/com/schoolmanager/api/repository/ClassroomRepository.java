package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.DTO.ClassroomDTO;
import com.schoolmanager.api.model.entities.Classroom;
import com.schoolmanager.api.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findClassroomByProfessors(Professor professor);
}
