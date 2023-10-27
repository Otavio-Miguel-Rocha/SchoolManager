package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.*;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User validation(@RequestBody UserValidation user){
        return userService.validation(user);
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

    @PostMapping
    public void post(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping
    public void put(@RequestBody User user) {
        userService.save(user);
    }

}
