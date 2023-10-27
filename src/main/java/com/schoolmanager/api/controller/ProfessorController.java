package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.entities.Test;
import com.schoolmanager.api.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/registerTest/{idClass}")
    public List<Test> registerTest(@PathVariable Integer idClass, @RequestParam Integer idProfessor, @RequestBody List<Test> tests){
        return professorService.registerTest(idClass, idProfessor, tests);
    }

}
