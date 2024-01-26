package com.example.carws.controller.categorie;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.Categorie;
import com.example.carws.service.CategorieService;

import com.example.carws.response.*;

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
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getCategory( @PathVariable("id") String id ) throws Exception{
		try{
			Categorie categorie = categorieService.getCategory(id);
			Response response = new Response();
			response.addData( "items" , categorie );
			return ResponseEntity.status(HttpStatus.OK).body( response );
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Response().addError( "exception", e.getMessage() ) );
		}
	}

	@PostMapping
	public ResponseEntity<Response> addCategorie( @RequestBody Categorie categorie ) throws Exception{
		Response response = new Response();
		try{
			categorieService.saveCategorie( categorie );
			response.addMessage("save", "La categorie a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateCategorie( @RequestBody Categorie categorie, @PathVariable("id") String id ){
		Response response = new Response();
		try{
			categorie.setId(id);
			categorieService.updateCategorie( categorie );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Categorie mis a jour" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteCategorie( @PathVariable("id") String id ){
		Response response = new Response();
		try{
			categorieService.deleteCategorie( id );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Categorie suppression" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

}