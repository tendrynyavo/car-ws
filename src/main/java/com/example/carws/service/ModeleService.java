package com.example.carws.service;
import com.example.carws.repository.ModeleRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;

@Service
public class ModeleService{

	@Autowired
	ModeleRepository repository;

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
    
}