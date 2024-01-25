/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.Categorie;
import com.example.carws.model.primaire.Couleur;
import com.example.carws.repository.CouleurRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class CouleurService {
          
          @Autowired CouleurRepository couleur;
          
          public List<Couleur> getAll() throws Exception{
                    return couleur.findAll();
          }
          
          public Couleur getCouleur( String id ) throws Exception{
                    return couleur.findById(id).orElseThrow();
          }
          
          public void saveCouleur( Couleur c ) throws Exception{
                    couleur.save(c);
          }
          
          public Couleur updateCouleur( Couleur c ) throws Exception{
                    Couleur category;
		try{
			category = this.getCouleur(c.getId() );
			category.setNom(c.getNom());
			category.setId(c.getId());
			category = couleur.save(category);
		}catch(CategorieException e){
			category = couleur.save( c );
		}catch (Exception e) {
			throw e;
		}
		return category;
          }
          
          public void deleteCouleur( String id ) throws Exception{
                    couleur.deleteById(id);
          }
          
}
