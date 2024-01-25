/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.carws.repository;

import com.example.carws.model.primaire.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sarobidy
 */
public interface CouleurRepository extends JpaRepository<Couleur, String> {
          
}
