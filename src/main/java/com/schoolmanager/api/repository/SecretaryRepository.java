package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.entities.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {
}
