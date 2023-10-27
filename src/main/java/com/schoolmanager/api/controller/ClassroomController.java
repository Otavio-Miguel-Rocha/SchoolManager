package com.schoolmanager.api.controller;


import com.schoolmanager.api.model.entities.Classroom;
import com.schoolmanager.api.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/class")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public Classroom findOneById(@PathVariable Integer id) {
        return classroomService.findById(id);
    }

    @GetMapping()
    public Collection<Classroom> findAll() {
        return classroomService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        classroomService.delete(id);
    }

    @PostMapping()
    public void post(@RequestBody Classroom classroom) {
        classroomService.save(classroom);
    }

    @PutMapping
    public void put(@RequestBody Classroom classroom) {
        classroomService.save(classroom);
    }
}
