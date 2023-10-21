package com.schoolmanager.api.controller;


import com.schoolmanager.api.model.Classroom;
import com.schoolmanager.api.model.enums.UserEnum;
import com.schoolmanager.api.service.ClassroomService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/class")
public class ClassroomController {
    private final ClassroomService classroomService;
    private final UserService userService;

    public ClassroomController(ClassroomService classService, UserService userService){
        this.classroomService = classService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Classroom findOneById(@PathVariable Integer id, @RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            return classroomService.findById(id);
        }
        return null;
    }

    @GetMapping()
    public Collection<Classroom> findAll(@RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            return classroomService.findAll();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestParam("id_class") Integer id, @RequestParam("id_user") Integer idUser) {
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            classroomService.delete(id);
        }
    }

    @PostMapping()
    public void post(@RequestBody Classroom classroom, @RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            classroomService.save(classroom);
        }
    }

    @PutMapping
    public void put(@RequestBody Classroom classroom, @RequestParam("id_user") Integer idUser) {
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            classroomService.save(classroom);
        }
    }
}
