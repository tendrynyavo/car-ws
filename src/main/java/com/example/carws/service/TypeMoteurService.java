/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.carws.service;

import com.example.carws.exception.CategorieException;
import com.example.carws.model.primaire.TypeMoteur;
import com.example.carws.repository.TypeMoteurRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarobidy
 */
@Service
public class TypeMoteurService {
        @Autowired  TypeMoteurRepository repository;
        @Autowired JdbcTemplate jdbc;
        
        public List<TypeMoteur> findAll() throws Exception{
                  return repository.findAll();
        }
        
        public TypeMoteur get(String id) throws Exception{
                 Optional<TypeMoteur> m = repository.findById(id);
                 if( !m.isPresent() ) throw new CategorieException("Le type de moteur n'existe pas");
                 return m.get();
        }
        
        public void save(TypeMoteur type) throws Exception{
                  repository.save(type);
        }
        
        public void update( TypeMoteur moteur ) throws Exception{
                  TypeMoteur m;
                  try{
                            m = this.get(moteur.getId());
                            m.setNom(moteur.getNom());
                            repository.save( m );
                  }catch(CategorieException e){
                            m = repository.save(moteur);
                  }catch(Exception e){
                            throw e;
                  }
        }
        
        public void delete(String id) throws Exception{
                  repository.deleteById(id);
        }
        
        
          public void addCarburantToEngine( String id_type, String carburant ) throws Exception{
                    String sql = "insert into type_carburant values ( nextval('seq_type_carburant') , '%s' , '%s' )";
                    sql = String.format(sql, carburant, id_type);
                    try{
                              jdbc.update(sql);
                    }catch(Exception e){
                              e.printStackTrace();
                              throw e;
                    }
          }
          
          public void addTransmission( String id_boite, String id_moteur ) throws Exception{
                    String sql = "insert into transmission values( nextval('seq_transmission') , '%s' , '%s' )";
                    sql = String.format( sql , id_boite, id_moteur );
                    try{
                              jdbc.update( sql );
                    }catch(Exception e){
                              e.printStackTrace();
                              throw e;
                    }
          }
        
}
