package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.Secretary;
import com.schoolmanager.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {
}
