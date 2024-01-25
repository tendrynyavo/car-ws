/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.Lieu;
import com.example.carws.repository.LieuRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class LieuService {
          
          @Autowired LieuRepository repository;
          
          public List<Lieu> list() throws Exception{
                    return (List<Lieu>) repository.findAll();
          }
          
          public Lieu get( String id ) throws Exception{
                    return repository.findById( id ).orElseThrow();
          }
          
          public void save(Lieu lieu) throws Exception{
                    repository.save(lieu);
          }
          
          public void update( Lieu lieu ) throws Exception{
                    Lieu l;
                    try{
                              l = this.get(lieu.getId());
                              l.setNom( lieu.getNom() );
                              l.setId( lieu.getId() );
                              l = repository.save(l);
                    }catch( CategorieException e ){
                              l = repository.save(lieu);
                    }catch(Exception e){
                              throw e;
                    }
          }
          
          public void delete( String id ) throws Exception{
                    repository.deleteById(id);
          }
          
}
