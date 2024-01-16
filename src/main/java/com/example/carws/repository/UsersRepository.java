package com.example.carws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.users.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    // Users findById(String id);
}