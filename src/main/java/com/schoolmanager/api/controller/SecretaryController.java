package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.entities.Professor;
import com.schoolmanager.api.model.DTO.ReportCardDTO;
import com.schoolmanager.api.model.entities.User;
import com.schoolmanager.api.service.ClassroomService;
import com.schoolmanager.api.service.SecretaryService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    private final SecretaryService secretaryService;

    public SecretaryController(SecretaryService secretaryService, ClassroomService classroomService, UserService userService){
        this.secretaryService = secretaryService;
    }

    @PutMapping("/class/{idClass}/user/{idUser}")
    public User associateUserWithClass(@PathVariable Integer idClass, @PathVariable Integer idUser){
        return secretaryService.associateUserWithClass
                (idClass, idUser);
    }

    @PostMapping("/class/{idClass}")
    public List<ReportCardDTO> generateReportCard(@PathVariable Integer idClass, @RequestParam Integer idSecretary){
        return secretaryService.generateReportCardByClass(idClass, idSecretary);
    }

    @PutMapping("/discipline/{idDiscipline}/professor/{idProfessor}")
    public Professor associateProfessorWithDiscipline(@PathVariable Integer idDiscipline, @PathVariable Integer idProfessor){
        return secretaryService.associateProfessorWithDiscipline(idDiscipline, idProfessor);
    }

}
