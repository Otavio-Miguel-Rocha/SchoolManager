package com.schoolmanager.api.controller;

import com.schoolmanager.api.model.Test;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.service.TestService;
import com.schoolmanager.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/test")
public class TestController {
    private TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/{id}")
    public Test findOneById(@PathVariable Integer id){
        return testService.findById(id);
    }

    @GetMapping()
    public Collection<Test> findAll(){
        return testService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam("value") Integer id) {
        testService.delete(id);
    }

    @PostMapping()
    public void post(@RequestBody Test test){
        testService.save(test);
    }

    @PutMapping
    public void put(@RequestBody Test test) {
        testService.save(test);
    }
}
