package com.example.carws.service;
import com.example.carws.repository.AnnonceFavoriesRepository;
import com.example.carws.repository.AnnoncePhotoRepository;
import com.example.carws.repository.AnnonceRepository;
import com.example.carws.repository.AnnonceVenduRepository;
import com.example.carws.repository.DetailsAnnonceRepository;
import com.example.carws.repository.UsersRepository;
import com.example.carws.repository.ValidateAnnonceRepository;
import com.example.carws.repository.VoitureRepository;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.annonce.*;
import com.example.carws.model.users.Users;
import com.example.carws.model.voiture.Voiture;
import com.example.carws.exception.*;

@Service
public class AnnonceService{

	@Autowired
	AnnonceRepository repository;

	@Autowired
	DetailsAnnonceRepository detailsRepository;

	@Autowired
	AnnoncePhotoRepository photoRepository;
	
	@Autowired
	ValidateAnnonceRepository validateRepository;

	@Autowired
	AnnonceVenduRepository venduRepository;

	@Autowired
	AnnonceFavoriesRepository favorisRepository;

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	UsersRepository userRepository;

	public List<Annonce> getAllAnnonces() throws Exception{
		return repository.findAll();
	}

	public Annonce getAnnonce( Integer id ) throws Exception{
		Annonce annonce = (Annonce)repository.findById( id ).orElse(null);
		if( annonce == null ){
			throw new CategorieException("L'annonce n'existe pas");
		}
		return annonce;
	}

	public void saveAnnonceWithDetails( Annonce annonce, DetailsAnnonce details, AnnoncePhoto[] annoncePhotos , Voiture voiture) throws Exception{
		annonce.setEtat(10);
		repository.save( annonce );

		details.setAnnonce(annonce);
		detailsRepository.save(details);

		voiture.setDetails(details);
		voitureRepository.save(voiture);

		for (AnnoncePhoto annoncePhoto : annoncePhotos) {
			annoncePhoto.setAnnonce(annonce);
			photoRepository.save(annoncePhoto);
		}		  
	}

	public Annonce updateAnnonce( Annonce annonce ) throws Exception{
		Annonce annonceUpdate;
		try{
			annonceUpdate = this.getAnnonce( annonce.getId() );
            annonceUpdate.setDateheure(annonce.getDateheure());
            annonceUpdate.setUser(annonce.getUser());
            annonceUpdate.setPrix(annonce.getPrix());
			annonceUpdate.setId(annonce.getId());
			annonceUpdate.setEtat(annonce.getEtat());
			annonceUpdate = repository.save(annonceUpdate);
		}catch(CategorieException e){
			annonceUpdate = repository.save( annonce );
		}catch (Exception e) {
			throw e;
		}
		return annonceUpdate;
	}

	@Transactional
	public void deleteAnnonce(Integer id) throws Exception {
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		if (optionalAnnonce.isPresent()) {
			Annonce annonce = optionalAnnonce.get();
			annonce.setEtat(20);
			repository.save(annonce);
		} else {
			throw new Exception("Annonce not found with id " + id);
		}
	}

	public List<Annonce> findAllAnnoncesEnAttente() {
		return repository.findByEtat(10); 
	}

	public List<ValidateAnnonce> findAllValidatedAnnonces() {
		return validateRepository.findAll(); 
	}
	  
	public List<AnnonceFavories> findAllAnnoncesFavories(Users user) {
		return favorisRepository.findAllByUser(user); 
	}

	public List<AnnonceVendus> findAllVenduAnnonces() {
		return venduRepository.findAll(); 
	}

	@Transactional
	public void saveValidateAnnonce( Integer id , ValidateAnnonce validateAnnonce ) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		if (!optionalAnnonce.isPresent() || optionalAnnonce.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " in saveValidateAnnonce()");
		}
		Annonce annonce = optionalAnnonce.get();
		annonce.setEtat(30);
		annonce = this.updateAnnonce(annonce);
		
		System.out.println("annonce : "+annonce.getId());

		validateAnnonce.setAnnonce(annonce);
		validateRepository.save(validateAnnonce);
	}

	@Transactional
	public void saveAnnonceVendu( Integer id , AnnonceVendus annonceVendu ) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		if (!optionalAnnonce.isPresent() || optionalAnnonce.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " in saveAnnonceVendu()");
		}
		Annonce annonce = optionalAnnonce.get();
		annonce.setEtat(50);
		annonce = this.updateAnnonce(annonce);
		
		System.out.println("annonce : "+annonce.getId());

		annonceVendu.setAnnonce(annonce);
		venduRepository.save(annonceVendu);
	}

	@Transactional
	public void saveAnnonceFavories( Integer id , AnnonceFavories annonceFavories , String idUser) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		Optional<Users> optionalUser = userRepository.findById(idUser);

		if (optionalAnnonce.isPresent()) {
			Annonce annonce = optionalAnnonce.get();
			annonce.setEtat(40);
			annonce = this.updateAnnonce(annonce);

			Users users = optionalUser.get();

			annonceFavories.setAnnonce(annonce);
			annonceFavories.setUser(users);
			favorisRepository.save(annonceFavories);
			
		} else {
			throw new Exception("Annonce not found with id " + id + " in saveAnnonceFavories()");
		}	  
	}

}