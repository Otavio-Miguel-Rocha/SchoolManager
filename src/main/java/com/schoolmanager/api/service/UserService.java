package com.schoolmanager.api.service;

import com.schoolmanager.api.model.DTO.UserValidationDTO;
import com.schoolmanager.api.model.entities.Professor;
import com.schoolmanager.api.model.entities.Secretary;
import com.schoolmanager.api.model.entities.Student;
import com.schoolmanager.api.model.entities.User;
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

    public User save(User user){
        if(user.getUserEnum() == UserEnum.PROFESSOR){
            return professorRepository.save(new Professor(user));
        } else if(user.getUserEnum() == UserEnum.SECRETARY){
            return secretaryRepository.save(new Secretary(user));
        } else if(user.getUserEnum() == UserEnum.STUDENT){
            return studentRepository.save(new Student(user));
        } else if (user.getUserEnum() == UserEnum.ADMIN) {
            return userRepository.save(user);
        }
        return null;
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


    public User validation(UserValidationDTO user){
        User userValidation = findById(user.getId());
        if(userValidation.getPassword().equals(user.getPassword())){
            return userValidation;
        }
        return null;
    }
}
