package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;
public interface CategorieRepository extends JpaRepository< Categorie, Integer >{
	List<Categorie> findByDeletedFalse();
	Categorie findByIdAndDeletedFalse( Integer id );
}