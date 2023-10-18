package com.schoolmanager.api.controller;


import com.schoolmanager.api.model.Classroom;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/class")
public class ClassroomController {
    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classService){
        this.classroomService = classService;
    }

    @GetMapping("/{id}")
    public User findOneById(@PathVariable Integer id){
        return classroomService.findById(id);
    }

    @GetMapping()
    public Collection<User> findAll(){
        return classroomService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam("value") Integer id) {
        classroomService.delete(id);
    }

    @PostMapping()
    public void post(@RequestBody Classroom classroom){
        classroomService.save(classroom);
    }

    @PutMapping
    public void put(@RequestBody Classroom classroom) {
        classroomService.save(classroom);
    }
}
