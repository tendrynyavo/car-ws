/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.Caracteristique;
import com.example.carws.repository.CaracteristiqueRepository;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CaracteristiqueService {
          
         @Autowired CaracteristiqueRepository repository;
         
         public Caracteristique[] getCaracteristiques() throws Exception{
                   return repository.findAll().toArray( new Caracteristique[0]);
         }
         
         public Caracteristique getCaracteristique( String id ) throws Exception{
                   return repository.findById(id).orElseThrow();
         }
         
         public void saveCaracteristique( Caracteristique c ) throws Exception{
                   repository.save(c);
         }
         
         public Caracteristique updateCaracteristique( Caracteristique carburant ) throws Exception{
		Caracteristique carbu;
		try{
			carbu = this.getCaracteristique(carburant.getId() );
			carbu.setNom(carburant.getNom());
			carbu.setId(carburant.getId());
			carbu = repository.save(carbu);
		}catch(CategorieException e){
			carbu = repository.save( carburant );
		}catch (Exception e) {
			throw e;
		}
		return carbu;
	}
         
         public void deleteCaracteristique( String id ) throws Exception{
		repository.deleteById(id);
	}
         
          
}
