/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.repository.MoteurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class MoteurService {
          
          @Autowired MoteurRepository repository;
          
          public List<Moteur> getAll() throws Exception{
                    return (List<Moteur>) repository.findAll();
          } 
          
          public Moteur get(String id) throws Exception{
                    Optional<Moteur> moteur = repository.findById(id);
                    if( !moteur.isPresent() ) throw new CategorieException("Le moteur n'existe pas");
                    return moteur.get();
          }
          
          public void save(Moteur moteur) throws Exception{
                    repository.save(moteur);
          }
          
          public void update(Moteur moteur) throws Exception{
                    Moteur m = this.get(moteur.getId());
                    m.setId(moteur.getId());
                    m.setNom(moteur.getNom());
                    m.setPuissance(moteur.getPuissance());
                    m.setType(moteur.getType());
                    m.setCylindre(moteur.getCylindre());
                    m.setCarburant(moteur.getCarburant());
                    m.setConfiguration(moteur.getConfiguration());
                    m.setMarque(moteur.getMarque());
                    repository.save( moteur );
          }
          
          public void delete( String id ) throws Exception{
                    repository.deleteById(id);
          }
          
}
