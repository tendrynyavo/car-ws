package com.example.carws.service;
import com.example.carws.repository.AnnonceFavoriesRepository;
import com.example.carws.repository.AnnonceRepository;
import com.example.carws.repository.AnnonceVenduRepository;
import com.example.carws.repository.CaracteristiqueRepository;
import com.example.carws.repository.DetailsAnnonceRepository;
import com.example.carws.repository.LieuRepository;
import com.example.carws.repository.UsersRepository;
import com.example.carws.repository.ValidateAnnonceRepository;
import com.example.carws.repository.VoitureRepository;
import com.example.carws.request.SearchedElements;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.annonce.*;
import com.example.carws.model.primaire.Caracteristique;
import com.example.carws.model.primaire.Lieu;
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
	LieuRepository lieuRepository;
	
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

    @Autowired
    CaracteristiqueRepository caracteristiqueRepository;

	@Autowired
	EntityManager entityManager;

	public List<Annonce> getAllAnnonces() throws Exception{
		return repository.findAll();
	}

	public Annonce getAnnonce( String id ) throws Exception{
		Annonce annonce = (Annonce)repository.findById( id ).orElse(null);
		if( annonce == null ){
			throw new CategorieException("L'annonce n'existe pas");
		}
		return annonce;
	}

	public List<Annonce> getAnnoncesByUser(Users user) {
        return repository.findByUser(user);
    }

    @Transactional
	public void saveAnnonceWithDetails( Annonce annonce, DetailsAnnonce details) throws Exception{

        Optional<Lieu> lieu = lieuRepository.findById(annonce.getLieu().getId());
        Voiture voiture = voitureRepository.findById(annonce.getVoiture().getId());
        Users user = userRepository.findById(annonce.getUser().getId()).orElseThrow(() -> new Exception("User not found in annonceService"));
        Optional<Caracteristique> caracteristique = caracteristiqueRepository.findById(details.getCaracteristique().getId());
        
        annonce.setLieu(lieu.get());
        annonce.setVoiture(voiture);
        annonce.setUser(user);

		repository.save( annonce );

		details.setAnnonce(annonce);
        details.setCaracteristique(caracteristique.get());

		detailsRepository.save(details);
	}

	public Annonce updateAnnonce( Annonce annonce ) throws Exception{
		Annonce annonceUpdate;
		try{
			annonceUpdate = this.getAnnonce( annonce.getId() );
			annonceUpdate.setDate(annonce.getDate());

			Optional<Users> user = userRepository.findById(annonce.getUser().getId());
            annonceUpdate.setUser(user.get());

            annonceUpdate.setPrix(annonce.getPrix());
			annonceUpdate.setId(annonce.getId());
			annonceUpdate.setDescription(annonce.getDescription());
			annonceUpdate.setPrix(annonce.getPrix());
			annonceUpdate.setValeur(annonce.getValeur());
			annonceUpdate.setVoiture(annonce.getVoiture());
			annonceUpdate = repository.save(annonceUpdate);
			
		}catch(CategorieException e){
			annonceUpdate = repository.save( annonce );
		}catch (Exception e) {
			throw e;
		}
		return annonceUpdate;
	}

// 	@Transactional
// 	public void deleteAnnonce(Integer id) throws Exception {
// 		Optional<Annonce> optionalAnnonce = repository.findById(id);
// 		if (optionalAnnonce.isPresent()) {
// 			Annonce annonce = optionalAnnonce.get();
// 			annonce.setEtat(20);
// 			repository.save(annonce);
// 		} else {
// 			throw new Exception("Annonce not found with id " + id);
// 		}
// 	}

	public List<Annonce> findAllAnnoncesEnAttente() {
		return repository.findByValeur(10); 
	}

	public List<ValidateAnnonce> findAllValidatedAnnonces() {
		return validateRepository.findAll(); 
	}
	  
	public List<AnnonceFavories> findAllAnnoncesFavories(Users user) {
		return favorisRepository.findAllByUser(user); 
	}

// 	public List<AnnonceVendus> findAllVenduAnnonces() {
// 		return venduRepository.findAll(); 
// 	}

	@Transactional
	public void saveValidateAnnonce( String id , ValidateAnnonce validateAnnonce ) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		if (!optionalAnnonce.isPresent() || optionalAnnonce.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " in saveValidateAnnonce()");
		}
		Annonce annonce = optionalAnnonce.get();
		annonce.setValeur(20);
		annonce = this.updateAnnonce(annonce);
		
		System.out.println("annonce : "+annonce.getId());
		System.out.println("user : "+validateAnnonce.getUser().getId());

		Optional<Users> user = userRepository.findById(validateAnnonce.getUser().getId());
		if (!user.isPresent() || user.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " for user in saveValidateAnnonce()");
		}

		System.out.println(user.get().getId());

		validateAnnonce.setAnnonce(annonce);
		validateAnnonce.setUser(user.get());

		validateRepository.save(validateAnnonce);
	}

	@Transactional
	public void saveAnnonceVendu( String id , AnnonceVendus annonceVendu ) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		if (!optionalAnnonce.isPresent() || optionalAnnonce.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " in saveAnnonceVendu()");
		}

		Optional<Users> user = userRepository.findById(annonceVendu.getUser().getId());
		if (!user.isPresent() || user.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " for user in saveAnnonceFavories()");
		}
		Annonce annonce = optionalAnnonce.get();
		annonce.setValeur(40);
		annonce = this.updateAnnonce(annonce);
		
		System.out.println("annonce : "+annonce.getId());

		annonceVendu.setUser(user.get());
		annonceVendu.setAnnonce(annonce);
		venduRepository.save(annonceVendu);
	}

	@Transactional
	public void saveAnnonceFavories( String id , AnnonceFavories annonceFavories ) throws Exception{
		Optional<Annonce> optionalAnnonce = repository.findById(id);
		Optional<Users> user = userRepository.findById(annonceFavories.getUser().getId());
		if (!user.isPresent() || user.get().getId() == null) {
			throw new Exception("Annonce not found or invalid with id " + id + " for user in saveAnnonceFavories()");
		}

		if (optionalAnnonce.isPresent()) {
			Annonce annonce = optionalAnnonce.get();

			Users users = user.get();

			annonceFavories.setAnnonce(annonce);
			annonceFavories.setUser(users);
			favorisRepository.save(annonceFavories);
			
		} else {
			throw new Exception("Annonce not found with id " + id + " in saveAnnonceFavories()");
		}	  
	}

// 	@Transactional
// 	public List<Annonce> getAnnoncesMatch(SearchedElements elements){
// 		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
// 		CriteriaQuery<Annonce> criteriaQuery = criteriaBuilder.createQuery(Annonce.class);
// 		Root<Annonce> root = criteriaQuery.from(Annonce.class);

// 		Predicate predicate = criteriaBuilder.equal(root.get("etat"), 30);

// 		HashMap<String, Object> conditions = elements.allConditions();

// 		for (Map.Entry<String, Object> condition : conditions.entrySet()) {
// 			if(condition.getValue() != null){
// 				predicate = addConditionIfNotNull(criteriaBuilder, root, predicate, condition.getKey(), condition.getValue());
// 			}
// 		}

// 		if (elements.getDescription() != null) {
// 			Join<Annonce, DetailsAnnonce> detailsJoin = root.join("details");
// 			predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(detailsJoin.get("description"), "%" + elements.getDescription() + "%"));
// 		}

// 		if (elements.getKilometrage() > 0) {
// 			predicate = addConditionIfNotNull(criteriaBuilder, root, predicate, "kilometrage", elements.getKilometrage());
// 		}

// 		if (elements.getMinIntervalle() != -1 && elements.getMaxIntervalle() > 0) {
// 			predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(root.get("prix"), elements.getMinIntervalle(), elements.getMaxIntervalle()));
// 		}

// 		criteriaQuery.where(predicate);

// 		TypedQuery<Annonce> query = entityManager.createQuery(criteriaQuery);
// 		List<Annonce> results = query.getResultList();

// 		return results;
// 	}

// 	Predicate addConditionIfNotNull(CriteriaBuilder criteriaBuilder, Root<Annonce> root, Predicate predicate, String attributeName, Object value) {
// 		if (value != null) {
// 			Join<Annonce, DetailsAnnonce> detailsJoin = root.join("details");
// 			Join<DetailsAnnonce, Voiture> voitureJoin = detailsJoin.join("voiture");
// 			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(voitureJoin.get(attributeName), value));
// 		}
// 		return predicate;
// 	}


}