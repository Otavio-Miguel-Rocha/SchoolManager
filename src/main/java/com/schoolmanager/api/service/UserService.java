package com.schoolmanager.api.service;

import com.schoolmanager.api.model.User;
import com.schoolmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
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
}
