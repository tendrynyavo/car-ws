/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.example.carws.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.carws.model.annonce.Historique;

/**
 *
 * @author sarobidy
 */
public interface HistoriqueRepository extends CrudRepository<Historique, String> {
        
}