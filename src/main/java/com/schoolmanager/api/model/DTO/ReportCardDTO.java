package com.schoolmanager.api.model.DTO;

import com.schoolmanager.api.model.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCardDTO {
    private Student student;
    private Double finalAverage;
}
