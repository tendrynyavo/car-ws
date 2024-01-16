package com.example.carws.service;
import com.example.carws.repository.VoitureRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.voiture.*;
import com.example.carws.exception.*;

@Service
public class VoitureService{

	@Autowired
	VoitureRepository repository;

	public List<Voiture> getAllVoitures() throws Exception{
		return repository.findAll();
	}

	public Voiture getVoiture( Integer id ) throws Exception{
		Voiture voiture = (Voiture)repository.findById( id ).orElse(null);
		if( voiture == null ){
			throw new CategorieException("La voiture n'existe pas");
		}
		return voiture;
	}

	public void saveVoiture( Voiture voiture ) throws Exception{
		repository.save( voiture );
	}

	// public Voiture updateAnnonce( Annonce annonce ) throws Exception{
	// 	Annonce annonceUpdate;
	// 	try{
	// 		annonceUpdate = this.getAnnonce( annonce.getId() );
    //         annonceUpdate.setDateheure(annonce.getDateheure());
    //         annonceUpdate.setUser(annonce.getUser());
    //         annonceUpdate.setPrix(annonce.getPrix());
	// 		annonceUpdate.setId(annonce.getId());
	// 		annonceUpdate = repository.save(annonceUpdate);
	// 	}catch(CategorieException e){
	// 		annonceUpdate = repository.save( annonce );
	// 	}catch (Exception e) {
	// 		throw e;
	// 	}
	// 	return annonceUpdate;
	// }

	// public void deleteAnnonce( Integer id ) throws Exception{
	// 	Annonce annonce;
	// 	try{
	// 		annonce = this.getAnnonce( id );
	// 		annonce.setDeleted(true);
	// 		repository.save(category);
	// 	}catch (Exception e) {
	// 		throw e;
	// 	}
	// }

}