package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Test> getTests(@RequestParam Integer idStudent){
        return studentService.getTests(idStudent);
    }
}
