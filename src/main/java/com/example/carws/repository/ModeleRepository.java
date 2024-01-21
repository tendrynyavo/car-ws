package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModeleRepository extends JpaRepository< Modele, Integer > {
          
	List<Modele> findByDeletedFalse();
	Modele findByIdAndDeletedFalse( Integer id );
         
          @Modifying
         @Query(value = "insert into a_modele_categorie values ( default, :modele, :categorie  )" , nativeQuery = true)
	void addModeleToCategorie( @Param("modele") Integer modele, @Param("categorie") Integer categorie ) throws Exception;
    
}