package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.Secretary;
import com.schoolmanager.api.model.Student;
import com.schoolmanager.api.model.Professor;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.model.enums.UserEnum;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findOneById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping()
    public Collection<User> findAll(){
        return userService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam("value") Integer id) {
        userService.delete(id);
    }

    @PostMapping("/{enum}")
    public void post(@RequestBody User user, @PathVariable UserEnum enumerator){
        if(enumerator == UserEnum.PROFESSOR){
            userService.save(new Professor(user));
        } else if(enumerator == UserEnum.SECRETARY){
            userService.save(new Secretary(user));
        } else if(enumerator == UserEnum.STUDENT){
            userService.save(new Student(user));
        }
    }

    @PutMapping
    public void put(@RequestBody User user) {
        userService.save(user);
    }

}
