package com.schoolmanager.api.service;

import com.schoolmanager.api.model.DTO.ReportCardDTO;
import com.schoolmanager.api.model.entities.*;
import com.schoolmanager.api.repository.SecretaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SecretaryService {

    private final UserService userService;
    private final SecretaryRepository secretaryRepository;
    private final ProfessorService professorService;
    private final StudentService studentService;
    private final ClassroomService classroomService;
    private final DisciplineService disciplineService;

    public List<ReportCardDTO> generateReportCardByClass(Integer idClassroom, Integer idSecretary) {

        Classroom classroom = classroomService.findById(idClassroom);
        Secretary secretary = secretaryRepository.findById(idSecretary).get();

        List<ReportCardDTO> reportCards = new ArrayList<>();
        for (Student student : classroom.getStudents()) {
            reportCards.add(secretary.generateReportCard(student));
        }
        secretary.setAmountReportCard(secretary.getAmountReportCard()+ classroom.getStudents().size());
        secretaryRepository.save(secretary);
        return reportCards;
    }

    public User associateUserWithClass(Integer idClassroom, Integer idUser) {
        Classroom classroom = classroomService.findById(idClassroom);
        User user = userService.findById(idUser);

        if (!(user instanceof Secretary)) {
            if (user instanceof Professor) {
                Professor professor = professorService.findById(idUser);
                if (professor.getDiscipline() != null) {
                    if (!classroom.getProfessors().contains(user)) {
                        classroom.getProfessors().add(professor);
                        professor.getClassrooms().add(classroom);
                        return professorService.save(professor);
                    } else {
                        throw new RuntimeException("This professor is already associated with this class");
                    }
                } else {
                    throw new RuntimeException("A professor cannot be associated with a class without having a discipline");
                }
            } else if (user instanceof Student) {
                Student student = studentService.findById(idUser);
                if (!classroom.getStudents().contains(user)) {
                    classroom.getStudents().add(student);
                    student.setClassroom(classroom);
                    return studentService.save(student);
                } else {
                    throw new RuntimeException("This student is already associated with this class");
                }
            }
        } else {
            throw new RuntimeException("A secretary cannot be associated with a class");
        }
        return null;
    }

    public Professor associateProfessorWithDiscipline(Integer idDiscipline, Integer idProfessor){
        Professor professor = professorService.findById(idProfessor);
        professor.setDiscipline(disciplineService.findById(idDiscipline));
        return professorService.save(professor);
    }


}
