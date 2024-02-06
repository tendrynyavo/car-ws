package com.example.carws.controller.voiture;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.carws.model.primaire.Coloriage;
import com.example.carws.model.users.Users;
import com.example.carws.model.voiture.Voiture;
import com.example.carws.request.CarRequest;
import com.example.carws.service.UsersService;
import com.example.carws.service.VoitureService;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController{

	@Autowired VoitureService voitureService;

	@Autowired UsersService userService;

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
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

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Response> getVoiture( @PathVariable("id") String id ) throws Exception{
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

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/user")
	public ResponseEntity<?> getVoituresByUser() {
		try{
			Voiture[] voitures =  voitureService.getVoituresByUser().toArray( new Voiture[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( voitures );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
    }

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping
	public ResponseEntity<Response> addVoiture( @RequestBody CarRequest v ) throws Exception{
		Response response = new Response();
		try{
			voitureService.saveVoiture(voiture.getCategorie(), voiture.getVitesse(), voiture.getMoteur(), voiture.getModele(), voiture.getKilometrage() );
			response.addMessage("save", "La voiture a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			e.printStackTrace();
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateCarburant( @RequestBody Voiture voiture, @PathVariable("id") String id ){
		Response response = new Response();
		try{
			voiture.setId(id);
			voitureService.updateVoiture( voiture );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Voiture mise a jour" ) );
		}catch (Exception e) {
			e.printStackTrace();
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping("/couleur")
	public ResponseEntity<Response> addColoriage( @RequestBody Coloriage coloriage ) throws Exception{
		Response response = new Response();
		try{
			voitureService.saveCouleurVoiture( coloriage.getVoiture(), coloriage.getCouleur(), coloriage.getDate() );
			response.addMessage("save", "La couleur de la voiture a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			e.printStackTrace();
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

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