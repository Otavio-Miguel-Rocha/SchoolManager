package com.schoolmanager.api.service;

import com.schoolmanager.api.model.Classroom;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClassroomService {
    private ClassRepository classRepository;

    public void save(Classroom classroom){
        classRepository.save(classroom);
    }
    public User findById(Integer id){
        return classRepository.findById(id).get();
    }
    public List<User> findAll(){
        return classRepository.findAll();
    }
    public void delete(Integer id){
        classRepository.deleteById(id);
    }
}
