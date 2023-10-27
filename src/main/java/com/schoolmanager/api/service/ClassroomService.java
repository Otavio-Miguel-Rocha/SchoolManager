package com.schoolmanager.api.service;

import com.schoolmanager.api.model.DTO.ClassroomDTO;
import com.schoolmanager.api.model.DTO.StudentDTO;
import com.schoolmanager.api.model.entities.Classroom;
import com.schoolmanager.api.model.entities.Professor;
import com.schoolmanager.api.model.entities.Student;
import com.schoolmanager.api.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public void save(Classroom classroom){
        classroomRepository.save(classroom);
    }

    public Classroom findById(Integer id){
        return classroomRepository.findById(id).get();
    }
    public List<Classroom> findAll(){
        return classroomRepository.findAll();
    }
    public void delete(Integer id){
        classroomRepository.deleteById(id);
    }

    public List<ClassroomDTO> getProfessorClasses(Professor professor){
        List<ClassroomDTO> classroomDTOS = new ArrayList<>();
        for ( Classroom classroom : classroomRepository.findClassroomByProfessors(professor) ) {
            ClassroomDTO classroomDTO = new ClassroomDTO();
            BeanUtils.copyProperties(classroom, classroomDTO);

            List<StudentDTO> studentDTOS = new ArrayList<>();
            for ( Student student : classroom.getStudents()) {
                StudentDTO studentDTO = new StudentDTO();
                BeanUtils.copyProperties(student, studentDTO);
                studentDTOS.add(studentDTO);
            }
            classroomDTO.setStudents(studentDTOS);
            classroomDTOS.add(classroomDTO);
        }
        return classroomDTOS;
    }
}
