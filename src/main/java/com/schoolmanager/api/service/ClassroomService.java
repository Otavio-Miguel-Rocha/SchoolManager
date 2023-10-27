package com.schoolmanager.api.service;

import com.schoolmanager.api.model.entities.Classroom;
import com.schoolmanager.api.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
