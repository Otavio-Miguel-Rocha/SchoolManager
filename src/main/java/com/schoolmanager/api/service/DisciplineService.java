package com.schoolmanager.api.service;

import com.schoolmanager.api.model.Discipline;
import com.schoolmanager.api.model.User;
import com.schoolmanager.api.repository.DisciplineRespository;
import com.schoolmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineService {
    private DisciplineRespository disciplineRespository;

    public void save(Discipline discipline){
        disciplineRespository.save(discipline);
    }
    public Discipline findById(Integer id){
        return disciplineRespository.findById(id).get();
    }
    public List<Discipline> findAll(){
        return disciplineRespository.findAll();
    }
    public void delete(Integer id){
        disciplineRespository.deleteById(id);
    }
}
