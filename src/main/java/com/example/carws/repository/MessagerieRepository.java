package com.example.carws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carws.model.users.Messagerie;

public interface MessagerieRepository extends JpaRepository<Messagerie, Integer> {
    
}
