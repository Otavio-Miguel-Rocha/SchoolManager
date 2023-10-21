package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.User;
import com.schoolmanager.api.service.ClassroomService;
import com.schoolmanager.api.service.SecretaryService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    private final SecretaryService secretaryService;
    private final ClassroomService classroomService;
    private final UserService userService;

    public SecretaryController(SecretaryService secretaryService, ClassroomService classroomService, UserService userService){
        this.secretaryService = secretaryService;
        this.classroomService = classroomService;
        this.userService = userService;
    }

    @PutMapping("/class/{idClass}/user/{idUser}")
    public User associateUserWithClass(@PathVariable Integer idClass, @PathVariable Integer idUser){
        return secretaryService.associateUserWithClass
                (classroomService.findById(idClass), userService.findById(idUser));
    }

    @PostMapping("/class/{idClass}")
    public User generateReportCard(@PathVariable Integer idClass){
//        return secretaryService.associateUserWithClass
//                (classroomService.findById(idClass), userService.findById(idUser));
    }


}
