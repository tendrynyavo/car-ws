package com.example.carws.service;
import com.example.carws.repository.CategorieRepository;
import com.example.carws.repository.ColoriageRepository;
import com.example.carws.repository.CouleurRepository;
import com.example.carws.repository.ModeleRepository;
import com.example.carws.repository.MoteurRepository;
import com.example.carws.repository.UsersRepository;
import com.example.carws.repository.VitesseRepository;
import com.example.carws.repository.VoitureRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.*;

import com.example.carws.model.primaire.Categorie;
import com.example.carws.model.primaire.Coloriage;
import com.example.carws.model.primaire.Couleur;
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

	@Autowired
	MoteurRepository moteurRepository;

	@Autowired
	UsersRepository userRepository;

	@Autowired
	ColoriageRepository coloriageRepository;

	@Autowired
	CouleurRepository couleurRepository;

	@PersistenceContext
    private EntityManager entityManager;

	public List<Voiture> getAllVoitures() throws Exception{
		List<Voiture> voitures = repository.findAll();
		// for (int i = 0; i < voitures.size(); i++) {
		// 	voitures.get(i).setCouleurActuelle(coloriageRepository.findLatestColor(voitures.get(i).getId()));
		// }
		return voitures;
	}

	public List<Voiture> getVoituresByUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String idUser = (String)authentication.getPrincipal();
		Users user = new Users();
		user.setId(idUser);
		List<Voiture> voitures = repository.findByUser(user);
		// for (int i = 0; i < voitures.size(); i++) {
		// 	voitures.get(i).setCouleurActuelle(coloriageRepository.findLatestColor(voitures.get(i).getId()));
		// }
		return voitures;
    }

	public Voiture getVoiture( String id ) throws Exception{
		Voiture voiture = (Voiture)repository.findById( id );
		// voiture.setCouleurActuelle(coloriageRepository.findLatestColor(id));
		if( voiture == null ){
			throw new CategorieException("La voiture n'existe pas");
		}
		return voiture;
	}

	public void saveVoiture(Categorie categorie, Vitesse vitesse, Moteur moteur, Modele modele, double kilometrage ) throws Exception{
		Categorie categorieExistant = categorieRepository.findByIdAndDeletedFalse(categorie.getId());
		Vitesse vitesseExistant = vitesseRepository.findByIdAndDeletedFalse(vitesse.getId());
		Modele modeleExistant = modeleRepository.findByIdAndDeletedFalse(modele.getId());
		Moteur moteurExistant = moteurRepository.findByIdAndDeletedFalse(moteur.getId());

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String idUser = (String)authentication.getPrincipal();

		Users userExistant = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("User not found in voitureService"));;
		
		Voiture voiture = new Voiture();
        voiture.setUser(userExistant);
        voiture.setCategorie(categorieExistant);
        voiture.setVitesse(vitesseExistant);
        voiture.setMoteur(moteurExistant);
        voiture.setModele(modeleExistant);
        voiture.setKilometrage(kilometrage);
		repository.save( voiture );
	}

	@Transactional
	public Voiture updateVoiture( Voiture voiture ) throws Exception{
		Voiture voitureUpdate;
		try{
			voitureUpdate = this.getVoiture(voiture.getId());
			Categorie categorieExistant = categorieRepository.findByIdAndDeletedFalse(voiture.getCategorie().getId());
			Modele modeleExistant = modeleRepository.findByIdAndDeletedFalse(voiture.getModele().getId());
			Moteur moteurExistant = moteurRepository.findByIdAndDeletedFalse(voiture.getMoteur().getId());
			Vitesse vitesseExistant = vitesseRepository.findByIdAndDeletedFalse(voiture.getVitesse().getId());

			// Build and execute the update query
			entityManager.createNativeQuery("UPDATE voiture SET id_categorie = :idCategorie, id_modele = :idModele, " +
                "id_moteur = :idMoteur, id_boite = :idBoite, kilometrage = :kilometrage " +
                "WHERE id_voiture = :idVoiture")
                .setParameter("idCategorie", categorieExistant.getId())
                .setParameter("idModele", modeleExistant.getId())
                .setParameter("idMoteur", moteurExistant.getId())
                .setParameter("idBoite", vitesseExistant.getId())
                .setParameter("kilometrage", voiture.getKilometrage())
                .setParameter("idVoiture", voiture.getId())
                .executeUpdate();
		}catch (Exception e) {
			throw e;
		}
		return voitureUpdate;
	}

	public void saveCouleurVoiture( Voiture voiture, Couleur couleur, Date dateApplication ) throws Exception{
		Voiture voitureExistant = this.getVoiture(voiture.getId());
		Optional<Couleur> couleurExistant = couleurRepository.findById(couleur.getId());
		
		Coloriage coloriage  = new Coloriage();
        coloriage.setCouleur(couleurExistant.get());
		coloriage.setVoiture(voitureExistant);
		coloriage.setDate(dateApplication);
		coloriageRepository.save( coloriage );
	}

	// public void deleteVoiture( String id ) throws Exception{
	// 	Voiture voiture;
	// 	try{
	// 		voiture = this.getVoiture( id );
	// 		voiture.setDeleted(true);
	// 		repository.save(category);
	// 	}catch (Exception e) {
	// 		throw e;
	// 	}
	// }

}