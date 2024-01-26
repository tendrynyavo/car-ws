package com.example.carws.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carws.model.users.Users;
import com.example.carws.model.voiture.* ;

public interface VoitureRepository extends JpaRepository< Voiture, Integer >{
    Voiture findById(String id);
    List<Voiture> findByUser(Users user);
}