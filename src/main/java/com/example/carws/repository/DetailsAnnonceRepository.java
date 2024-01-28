package com.example.carws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carws.model.annonce.* ;

public interface DetailsAnnonceRepository extends JpaRepository< DetailsAnnonce, String > {
    
}
