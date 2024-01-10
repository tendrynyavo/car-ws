package com.example.carws.controller.categorie;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.Categorie;
import com.example.carws.service.CategorieService;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController{

	@Autowired CategorieService categorieService;

	@GetMapping
	public ResponseEntity<?> getCategories() throws Exception{
		try{
			Categorie[] categories = new Categorie().test();
			categories = categorieService.getAllCategories().toArray( new Categorie[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( categories );
		}catch( Exception exception ){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

}