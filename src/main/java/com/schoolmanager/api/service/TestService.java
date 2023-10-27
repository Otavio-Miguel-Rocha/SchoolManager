package com.schoolmanager.api.service;

import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    public Test save(Test test){
        return testRepository.save(test);
    }
    public Test findById(Integer id){
        return testRepository.findById(id).get();
    }
    public List<Test> findAll(){
        return testRepository.findAll();
    }
    public void delete(Integer id){
        testRepository.deleteById(id);
    }
}
