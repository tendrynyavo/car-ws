package com.example.carws.service;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.exception.*;
import com.example.carws.model.primaire.Vitesse;
import com.example.carws.repository.VitesseRepository;

@Service
public class VitesseService{

	@Autowired
	VitesseRepository repository;

	public List<Vitesse> getAllVitesses() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Vitesse getVitesse( Integer id ) throws Exception{
		Vitesse c = (Vitesse)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("La Vitesse n'existe pas");
		}
		return c;
	}


	public void saveVitesse( Vitesse marque ) throws Exception{
		repository.save( marque );
	}

	public Vitesse updateVitesse( Vitesse Vitesse ) throws Exception{
		Vitesse m;
		try{
			m = this.getVitesse( Vitesse.getId() );
			m.setNom(Vitesse.getNom());
			m.setId(Vitesse.getId());
			m = repository.save(m);
		}catch(CategorieException e){
			m = repository.save( Vitesse );
		}catch (Exception e) {
			throw e;
		}
		return m;
	}

	public void deleteVitesse( Integer id ) throws Exception{
		Vitesse marque;
		try{
			marque = this.getVitesse( id );
			marque.setDeleted(true);
			repository.save(marque);
		}catch (Exception e) {
			throw e;
		}
	}

}