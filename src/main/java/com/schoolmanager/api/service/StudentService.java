package com.schoolmanager.api.service;

import com.schoolmanager.api.model.entities.Student;
import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    StudentRepository studentRepository;

    public List<Test> getTests(Integer idStudent){
        return findById(idStudent).getTests();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }
    public Student findById(Integer id){
        return studentRepository.findById(id).get();
    }
}
