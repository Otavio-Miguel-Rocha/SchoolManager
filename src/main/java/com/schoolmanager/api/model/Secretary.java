package com.schoolmanager.api.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SECRETARY")
public class Secretary extends User{

    private Integer amountReportCard;

    public Secretary(User user){
        super(user);
    }
}
