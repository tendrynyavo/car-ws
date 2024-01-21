/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.service.model;

import com.example.carws.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class ModelCategorieService {
          
          @Autowired ModeleRepository repository;
          
          public void addModelToCategory( Integer modele, Integer categorie ) throws Exception{
                    repository.addModeleToCategorie(modele, categorie);
          }
          
}
