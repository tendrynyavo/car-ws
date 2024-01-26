package com.example.carws.service;
import com.example.carws.repository.ModeleRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class ModeleService{

	@Autowired
	ModeleRepository repository;
          
          @Autowired
          JdbcTemplate jdbc;

	public List<Modele> getAllModeles() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Modele getModele( String id ) throws Exception{
		Modele c = (Modele)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("Le modele n'existe pas");
		}
		return c;
	}


	public void saveModele( Modele modele ) throws Exception{
		repository.save( modele );
	}

	public Modele updateModele( Modele modele ) throws Exception{
		Modele m;
		try{
			m = this.getModele( modele.getId() );
			m.setNom(modele.getNom());
			m.setId(modele.getId());
			m = repository.save(m);
		}catch(CategorieException e){
			m = repository.save( modele );
		}catch (Exception e) {
			throw e;
		}
		return m;
	}

	public void deleteModele( String id ) throws Exception{
		Modele modele;
		try{
			modele = this.getModele( id );
			modele.setDeleted(true);
			repository.save(modele);
		}catch (Exception e) {
			throw e;
		}
	}
    
          public void addEngineToModel( String id_model, String id_motor ) throws Exception{
                    String sql = "insert into specificite values ( nextval('seq_specificite') , '%s' , '%s' )";
                    sql = String.format(sql, id_model, id_motor);
                    try{
                          jdbc.update(sql);
                    }catch(Exception e){
                              e.printStackTrace();
                              throw e;
                    }
          }
          
          public void addCategoryToModel( String id_model, String id_category ) throws Exception{
                    String sql = "insert into design values (nextval('seq_design') , '%s' , '%s')";
                     sql = String.format(sql, id_category, id_model);
                     try{
                               jdbc.update(sql);
                     }catch(Exception e){
                               e.printStackTrace();
                               throw e;
                     }
          }
          
    
}