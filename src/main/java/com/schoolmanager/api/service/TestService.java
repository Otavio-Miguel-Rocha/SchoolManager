package com.schoolmanager.api.service;

import com.schoolmanager.api.model.Test;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.repository.TestRepository;
import com.schoolmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

    private TestRepository testRepository;
    public void save(Test test){
        testRepository.save(test);
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
