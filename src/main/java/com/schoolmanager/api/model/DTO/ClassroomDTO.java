package com.schoolmanager.api.model.DTO;

import com.schoolmanager.api.model.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDTO {
    private Integer id;
    private String className;
    private List<StudentDTO> students;
}
