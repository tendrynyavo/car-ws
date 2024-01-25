package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.carws.model.annonce.* ;
import java.util.*;

public interface AnnonceRepository extends JpaRepository< Annonce, Integer >{
	// @Query("SELECT DISTINCT a FROM Annonce a LEFT JOIN FETCH a.details")
	// List<Annonce> findAllAnnoncesWithDetails();
	
	// List<Annonce> findByEtat( Integer etat );
	// List<Annonce> findByEtatAndUser( Integer etat, String user );
}