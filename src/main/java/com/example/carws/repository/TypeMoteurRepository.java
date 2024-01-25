/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.carws.repository;

import com.example.carws.model.primaire.TypeMoteur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sarobidy
 */
public interface TypeMoteurRepository extends JpaRepository<TypeMoteur, String> {
          
}
