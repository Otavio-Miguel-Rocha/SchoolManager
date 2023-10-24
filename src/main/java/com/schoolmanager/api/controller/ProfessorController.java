package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.Classroom;
import com.schoolmanager.api.model.ReportCard;
import com.schoolmanager.api.model.Test;
import com.schoolmanager.api.service.ClassroomService;
import com.schoolmanager.api.service.ProfessorService;
import com.schoolmanager.api.service.SecretaryService;
import com.schoolmanager.api.service.UserService;
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
    public List<Test> registerTest(@PathVariable Integer idClass, @RequestBody List<Test> tests, @RequestParam Integer idProfessor){
        return professorService.registerTest(idClass, idProfessor, tests);
    }

}
