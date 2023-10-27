package com.schoolmanager.api.model.DTO;

import com.schoolmanager.api.model.entities.Discipline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private Double grade;
    private Discipline discipline;
    private Integer idStudent;
}
