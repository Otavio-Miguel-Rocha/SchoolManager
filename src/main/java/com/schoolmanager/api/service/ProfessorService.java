package com.schoolmanager.api.service;

import com.schoolmanager.api.model.DTO.TestDTO;
import com.schoolmanager.api.model.entities.Classroom;
import com.schoolmanager.api.model.entities.Professor;
import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ClassroomService classroomService;
    private final TestService testService;
    private final StudentService studentService;

    public List<Test> registerTest(Integer idClass, Integer idProfessor, List<TestDTO> tests){
        Classroom classroom = classroomService.findById(idClass);
        Professor professor = professorRepository.findById(idProfessor).get();

        List<Test> testsReturn = new ArrayList<>();
        if(classroom.getProfessors().contains(professor)){
            for ( TestDTO testDTO : tests) {
                Test test = new Test(testDTO.getGrade(), studentService.findById(testDTO.getIdStudent()) , professor.getDiscipline());
                testsReturn.add(test);
                testService.save(test);
            }
            return testsReturn;
        } else{
            throw new RuntimeException("The professor is not associated with this class!");
        }
    }

    public Professor findById(Integer id){
        return professorRepository.findById(id).get();
    }

    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }
}
