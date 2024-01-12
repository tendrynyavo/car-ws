package com.example.carws.service;
import com.example.carws.repository.CarburantRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;

@Service
public class CarburantService{

	@Autowired
	CarburantRepository repository;

	public List<Carburant> getAllCarburants() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Carburant getCarburant( Integer id ) throws Exception{
		Carburant c = (Carburant)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("Le type de Carburant n'existe pas");
		}
		return c;
	}


	public void saveCarburant( Carburant carburant ) throws Exception{
		repository.save( carburant );
	}

	public Carburant updateCarburant( Carburant carburant ) throws Exception{
		Carburant carbu;
		try{
			carbu = this.getCarburant( carburant.getId() );
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

	public void deleteCarburant( Integer id ) throws Exception{
		Carburant carburant;
		try{
			carburant = this.getCarburant( id );
			carburant.setDeleted(true);
			repository.save(carburant);
		}catch (Exception e) {
			throw e;
		}
	}

}