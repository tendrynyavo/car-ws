package com.example.carws.service;
import com.example.carws.repository.CategorieRepository;
import com.example.carws.repository.ModeleRepository;
import com.example.carws.repository.VitesseRepository;
import com.example.carws.repository.VoitureRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.Categorie;
import com.example.carws.model.primaire.Modele;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.model.primaire.Vitesse;
import com.example.carws.model.users.Users;
import com.example.carws.model.voiture.*;
import com.example.carws.exception.*;

@Service
public class VoitureService{

	@Autowired
	VoitureRepository repository;

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	VitesseRepository vitesseRepository;

	@Autowired
	ModeleRepository modeleRepository;

	public List<Voiture> getAllVoitures() throws Exception{
		return repository.findAll();
	}

	public Voiture getVoiture( String id ) throws Exception{
		Voiture voiture = (Voiture)repository.findById( id );
		if( voiture == null ){
			throw new CategorieException("La voiture n'existe pas");
		}
		return voiture;
	}

	public void saveVoiture( Users user, Categorie categorie, Vitesse vitesse, Moteur moteur, Modele modele, double kilometrage ) throws Exception{
		Categorie categorieExistant = categorieRepository.findByIdAndDeletedFalse(categorie.getId());
		Vitesse vitesseExistant = vitesseRepository.findByIdAndDeletedFalse(vitesse.getId());
		Modele modeleExistant = modeleRepository.findByIdAndDeletedFalse(modele.getId());
		
		Voiture voiture = new Voiture();
        voiture.setUser(user);
        voiture.setCategorie(categorieExistant);
        voiture.setVitesse(vitesseExistant);
        voiture.setMoteur(moteur);
        voiture.setModele(modeleExistant);
        voiture.setKilometrage(kilometrage);
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