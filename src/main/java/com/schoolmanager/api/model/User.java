package com.schoolmanager.api.model;

import com.schoolmanager.api.model.enums.UserEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String username;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 30)
    private String password;
    private String address;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserEnum userEnum;
}
