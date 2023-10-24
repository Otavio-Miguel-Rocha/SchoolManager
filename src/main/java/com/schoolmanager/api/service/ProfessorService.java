package com.schoolmanager.api.service;

import com.schoolmanager.api.model.*;
import com.schoolmanager.api.repository.ClassroomRepository;
import com.schoolmanager.api.repository.DisciplineRespository;
import com.schoolmanager.api.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ClassroomService classroomService;

    public List<Test> registerTest(Integer idClass, Integer idProfessor, List<Test> tests){
        Classroom classroom = classroomService.findById(idClass);
        Professor professor = professorRepository.findById(idProfessor).get();
        if(classroom.getProfessors().contains(professor)){
            for ( Test test : tests) {

            }
        } else{
            throw new RuntimeException("The professor is not associated with this class!");
        }
        return null;
    }
}
