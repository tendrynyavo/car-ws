package com.example.carws.controller.voiture;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.voiture.Voiture;
import com.example.carws.service.VoitureService;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/voiture")
public class VoitureController{

	@Autowired VoitureService voitureService;

	@GetMapping
	public ResponseEntity<?> getVoitures() throws Exception{
		try{
			Voiture[] voitures = voitureService.getAllVoitures().toArray( new Voiture[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( voitures );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getVoiture( @PathVariable("id") Integer id ) throws Exception{
		try{
			Voiture voiture = voitureService.getVoiture(id);
			Response response = new Response();
			response.addData( "voiture" , voiture );
			return ResponseEntity.status(HttpStatus.OK).body( response );
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Response().addError( "exception", e.getMessage() ) );
		}
	}

	@PostMapping
	public ResponseEntity<Response> addVoiture( @RequestBody Voiture voiture ) throws Exception{
		Response response = new Response();
		try{
			voitureService.saveVoiture( voiture );
			response.addMessage("save", "La voiture a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	// @PutMapping("/{id}")
	// public ResponseEntity<Response> updateCategorie( @RequestBody Voiture categorie, @PathVariable("id") Integer id ){
	// 	Response response = new Response();
	// 	try{
	// 		categorie.setId(id);
	// 		categorieService.updateCategorie( categorie );
	// 		return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Categorie mis a jour" ) );
	// 	}catch (Exception e) {
	// 		response.addError("error" , e.getMessage());
	// 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
	// 	}
	// }

	// @DeleteMapping("/{id}")
	// public ResponseEntity<Response> deleteCategorie( @PathVariable("id") Integer id ){
	// 	Response response = new Response();
	// 	try{
	// 		categorieService.deleteCategorie( id );
	// 		return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Categorie suppression" ) );
	// 	}catch (Exception e) {
	// 		response.addError("error" , e.getMessage());
	// 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
	// 	}
	// }

}