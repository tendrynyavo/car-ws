package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.carws.model.primaire.*;
import java.util.*;
public interface CategorieRepository extends JpaRepository< Categorie, String > {
	@Query( value = "select id_categorie, nom, deleted, null as id_design from categorie where deleted = false", nativeQuery = true )
	List<Categorie> findByDeletedFalse();
	@Query( value = "select id_categorie, nom, deleted , null as id_design from categorie where deleted = false and id_categorie = :id", nativeQuery = true )
	Categorie findByIdAndDeletedFalse( @Param("id") String id );
}