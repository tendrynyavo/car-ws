package com.example.carws.service;
import com.example.carws.repository.CategorieRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;

@Service
public class CategorieService{

	@Autowired
	CategorieRepository repository;

	public List<Categorie> getAllCategories(  ) throws Exception{
		return repository.findAll();
	}


}