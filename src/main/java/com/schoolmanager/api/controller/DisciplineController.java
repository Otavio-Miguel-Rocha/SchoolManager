package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.entities.Discipline;
import com.schoolmanager.api.service.DisciplineService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService, UserService userService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/{id}")
    public Discipline findOneById(@PathVariable Integer id) {
        return disciplineService.findById(id);
    }

    @GetMapping()
    public Collection<Discipline> findAll() {
        return disciplineService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        disciplineService.delete(id);
    }

    @PostMapping()
    public void post(@RequestBody Discipline discipline) {
        disciplineService.save(discipline);
    }

    @PutMapping
    public void put(@RequestBody Discipline discipline) {
        disciplineService.save(discipline);
    }

}
