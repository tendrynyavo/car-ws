package com.example.carws.service;
import com.example.carws.repository.MarqueRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;

@Service
public class MarqueService{

	@Autowired
	MarqueRepository repository;

	public List<Marque> getAllMarques() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Marque getMarque( String id ) throws Exception{
		Marque c = (Marque)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("La marque n'existe pas");
		}
		return c;
	}

	public void saveMarque( Marque marque ) throws Exception{
		repository.save( marque );
	}

	public Marque updateMarque( Marque marque ) throws Exception{
		Marque m;
		try{
			m = this.getMarque( marque.getId() );
			m.setNom(marque.getNom());
			m.setId(marque.getId());
			m = repository.save(m);
		}catch(CategorieException e){
			m = repository.save( marque );
		}catch (Exception e) {
			throw e;
		}
		return m;
	}

	public void deleteMarque( String id ) throws Exception{
		Marque marque;
		try{
			marque = this.getMarque( id );
			marque.setDeleted(true);
			repository.save(marque);
		}catch (Exception e) {
			throw e;
		}
	}

}