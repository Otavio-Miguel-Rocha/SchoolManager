package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.Discipline;
import com.schoolmanager.api.model.enums.UserEnum;
import com.schoolmanager.api.service.DisciplineService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;
    private final UserService userService;

    public DisciplineController(DisciplineService disciplineService, UserService userService){
        this.disciplineService = disciplineService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Discipline findOneById(@PathVariable Integer id, @RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            return disciplineService.findById(id);
        }
        return null;
    }

    @GetMapping()
    public Collection<Discipline> findAll(@RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            return disciplineService.findAll();
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestParam("value") Integer id, @RequestParam("id_user") Integer idUser) {
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            disciplineService.delete(id);
        }
    }

    @PostMapping()
    public void post(@RequestBody Discipline discipline, @RequestParam("id_user") Integer idUser){
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            disciplineService.save(discipline);
        }
    }

    @PutMapping
    public void put(@RequestBody Discipline discipline, @RequestParam("id_user") Integer idUser) {
        if(userService.findById(idUser).getUserEnum() == UserEnum.SECRETARY){
            disciplineService.save(discipline);
        }
    }

}
