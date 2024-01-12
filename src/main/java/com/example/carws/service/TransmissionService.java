package com.example.carws.service;
import com.example.carws.repository.TransmissionRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;

@Service
public class TransmissionService{

	@Autowired
	TransmissionRepository repository;

	public List<Transmission> getAllTransmissions() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Transmission getTransmission( Integer id ) throws Exception{
		Transmission c = (Transmission)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("La transmission n'existe pas");
		}
		return c;
	}


	public void saveTransmission( Transmission marque ) throws Exception{
		repository.save( marque );
	}

	public Transmission updateTransmission( Transmission transmission ) throws Exception{
		Transmission m;
		try{
			m = this.getTransmission( transmission.getId() );
			m.setNom(transmission.getNom());
			m.setId(transmission.getId());
			m = repository.save(m);
		}catch(CategorieException e){
			m = repository.save( transmission );
		}catch (Exception e) {
			throw e;
		}
		return m;
	}

	public void deleteTransmission( Integer id ) throws Exception{
		Transmission marque;
		try{
			marque = this.getTransmission( id );
			marque.setDeleted(true);
			repository.save(marque);
		}catch (Exception e) {
			throw e;
		}
	}

}