package com.schoolmanager.api.service;

import com.schoolmanager.api.model.*;
import com.schoolmanager.api.model.enums.UserEnum;
import com.schoolmanager.api.repository.ProfessorRepository;
import com.schoolmanager.api.repository.SecretaryRepository;
import com.schoolmanager.api.repository.StudentRepository;
import com.schoolmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SecretaryRepository secretaryRepository;

    public void save(User user){
        if(user.getUserEnum() == UserEnum.PROFESSOR){

            professorRepository.save(new Professor(user));

        } else if(user.getUserEnum() == UserEnum.SECRETARY){

            secretaryRepository.save(new Secretary(user));

        } else if(user.getUserEnum() == UserEnum.STUDENT){

            studentRepository.save(new Student(user));

        }
    }
    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }


    public User validation(UserValidation user){
        User userValidation = findById(user.getId());
        if(userValidation.getPassword().equals(user.getPassword())){
            return userValidation;
        }
        return null;
    }
}
