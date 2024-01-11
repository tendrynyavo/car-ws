package com.example.carws.service;
import com.example.carws.repository.CategorieRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.exception.*;

@Service
public class CategorieService{

	@Autowired
	CategorieRepository repository;

	public List<Categorie> getAllCategories() throws Exception{
		return repository.findByDeletedFalse();
	}

	public Categorie getCategory( Integer id ) throws Exception{
		Categorie c = (Categorie)repository.findByIdAndDeletedFalse( id );
		if( c == null ){
			throw new CategorieException("La categorie n'existe pas");
		}
		return c;
	}


	public void saveCategorie( Categorie categorie ) throws Exception{
		repository.save( categorie );
	}

	public Categorie updateCategorie( Categorie categorie ) throws Exception{
		Categorie category;
		try{
			category = this.getCategory( categorie.getId() );
			category.setNom(categorie.getNom());
			category.setId(categorie.getId());
			category = repository.save(category);
		}catch(CategorieException e){
			category = repository.save( categorie );
		}catch (Exception e) {
			throw e;
		}
		return category;
	}

	public void deleteCategorie( Integer id ) throws Exception{
		Categorie category;
		try{
			category = this.getCategory( id );
			category.setDeleted(true);
			repository.save(category);
		}catch (Exception e) {
			throw e;
		}
	}

}