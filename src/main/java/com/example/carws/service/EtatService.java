/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.Etat;
import com.example.carws.repository.EtatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class EtatService {
          @Autowired
          EtatRepository repository;
          
          public List<Etat> getAll() throws Exception{
                    return (List<Etat>) repository.findAll();
          }
          
          public Etat get(Integer etat) throws Exception{
                    Optional<Etat> etats = repository.findById(etat);
                    if( !etats.isPresent() ) throw new CategorieException("L'etat n'existe pas");
                    return etats.get();
          }
          
          public void save( Etat etat ) throws Exception{
                    repository.save(etat);
          }
          
          public void update( Etat t ) throws Exception {
                    try{
                              Etat etat = this.get(t.getValeur());
                              etat.setNom( t.getNom() );
                              save(etat);
                    }catch(Exception e){
                             throw e;
                    }
          }
          
          public void delete(Integer etat) throws Exception{
                    repository.deleteById(etat);
          }
          
}
