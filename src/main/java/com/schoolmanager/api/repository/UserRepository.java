package com.schoolmanager.api.repository;

import com.schoolmanager.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
