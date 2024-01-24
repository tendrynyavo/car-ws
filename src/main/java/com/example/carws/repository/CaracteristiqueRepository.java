/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.repository;

import com.example.carws.model.primaire.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sarobidy
 */
public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, String> {
          
}
