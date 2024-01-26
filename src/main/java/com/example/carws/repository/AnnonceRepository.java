package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.carws.model.annonce.* ;
import com.example.carws.model.users.Users;

import java.util.*;

public interface AnnonceRepository extends JpaRepository< Annonce, String >{
	@Query("SELECT DISTINCT a FROM Annonce a LEFT JOIN FETCH a.details")
	List<Annonce> findAllAnnoncesWithDetails();
	
	List<Annonce> findByValeur( Integer valeur );
	List<Annonce> findByUser(Users user);
}