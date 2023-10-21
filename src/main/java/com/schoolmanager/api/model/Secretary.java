package com.schoolmanager.api.model;

import jakarta.annotation.PostConstruct;
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

    private Integer amountReportCard;

    public Secretary(User user){
        super(user);
    }


    public ReportCard generateReportCard(Student student){
        double sum = 0;
        for (Test test : student.getTests()) {
            sum += test.getGrade();
        }
        return new ReportCard(student, (sum/student.getTests().size()));
    }
}

