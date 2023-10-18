package com.schoolmanager.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity

public class KindUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kind_name")
    private String kindName;

    @ManyToOne
    @JoinColumn(name = "id_perm")
    private Permission permission;


}

