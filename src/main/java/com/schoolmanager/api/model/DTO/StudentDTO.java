package com.schoolmanager.api.model.DTO;

import com.schoolmanager.api.model.entities.Test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    private String username;
    private List<TestDTO> tests;
}
