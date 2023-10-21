package com.schoolmanager.api.service;

import com.schoolmanager.api.model.*;
import com.schoolmanager.api.model.enums.UserEnum;
import com.schoolmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SecretaryService {
    private final Secretary secretary;
    private final UserRepository userRepository;

    public List<ReportCard> generateReportCardByClass(Classroom classroom) {
        List<ReportCard> reportCards = new ArrayList<>();
        for (Student student : classroom.getStudents()) {
            reportCards.add(secretary.generateReportCard(student));
        }
        return reportCards;
    }

    public User associateUserWithClass(Classroom classroom, User user) {
        if (!(user instanceof Secretary)) {
            if (user instanceof Professor professor) {
                if (professor.getDiscipline() != null) {
                    if (!classroom.getProfessors().contains(user)) {
                        classroom.getProfessors().add(professor);
                        professor.getClassrooms().add(classroom);
                        return userRepository.save(professor);
                    } else {
                        throw new RuntimeException("This professor is already associated with this class");
                    }
                } else {
                    throw new RuntimeException("A professor cannot be associated with a class without having a discipline");
                }
            } else if (user instanceof Student student) {
                if (!classroom.getStudents().contains(user)) {
                    classroom.getStudents().add(student);
                    student.setClassroom(classroom);
                    return userRepository.save(student);
                } else {
                    throw new RuntimeException("This student is already associated with this class");
                }
            }
        } else {
            throw new RuntimeException("A secretary cannot be associated with a class");
        }
        return null;
    }


}
