package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.DTO.ClassroomDTO;
import com.schoolmanager.api.model.DTO.TestDTO;
import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.service.ClassroomService;
import com.schoolmanager.api.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;
    private final ClassroomService classroomService;

    public ProfessorController(ProfessorService professorService, ClassroomService classroomService) {
        this.professorService = professorService;
        this.classroomService = classroomService;
    }

    @PostMapping("/registerTest/{idClass}")
    public List<Test> registerTest(@PathVariable Integer idClass, @RequestParam Integer idProfessor, @RequestBody List<TestDTO> tests){
        return professorService.registerTest(idClass, idProfessor, tests);
    }

    @GetMapping("/classes")
    public List<ClassroomDTO> getClasses(@RequestParam Integer idProfessor){
        return classroomService.getProfessorClasses(professorService.findById(idProfessor));
    }

}
