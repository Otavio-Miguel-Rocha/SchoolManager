package com.schoolmanager.api.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SECRETARY")
public class Secretary extends User{

    private Integer amountReportCard;

    public Secretary(User user){
        super(user);
    }
}
