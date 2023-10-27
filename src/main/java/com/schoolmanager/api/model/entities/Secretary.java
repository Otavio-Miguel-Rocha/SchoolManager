package com.schoolmanager.api.model.entities;

import com.schoolmanager.api.model.DTO.ReportCardDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Secretary extends User{

    private Integer amountReportCard = 0;

    public Secretary(User user){
        super(user);
    }


    public ReportCardDTO generateReportCard(Student student){
        double sum = 0;
        for (Test test : student.getTests()) {
            sum += test.getGrade();
        }
        return new ReportCardDTO(student, (sum/student.getTests().size()));
    }
}

