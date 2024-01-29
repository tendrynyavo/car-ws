package com.example.carws.controller.annonce;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.annonce.AnnonceFavories;
import com.example.carws.model.annonce.AnnonceVendus;
import com.example.carws.model.annonce.DetailsAnnonce;
import com.example.carws.model.annonce.ValidateAnnonce;
import com.example.carws.model.users.Users;
import com.example.carws.request.AnnonceRequest;
import com.example.carws.request.SearchedElements;
import com.example.carws.service.AnnonceService;
import com.example.carws.response.*;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceController{

	@Autowired AnnonceService annonceService;

	@GetMapping("/list")
	public ResponseEntity<?> getAnnonces() throws Exception{
		try{
			Annonce[] annonces = annonceService.getAllAnnonces().toArray( new Annonce[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( annonces );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getAnnonce( @PathVariable("id") String id ) throws Exception{
		try{
			Annonce annonce = annonceService.getAnnonce(id);
			Response response = new Response();
			response.addData( "annonce" , annonce );
			return ResponseEntity.status(HttpStatus.OK).body( response );
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Response().addError( "exception", e.getMessage() ) );
		}
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping
	public ResponseEntity<Response> addAnnonce( @RequestBody AnnonceRequest request ) throws Exception{
		Response response = new Response();
		try{

			DetailsAnnonce details = request.getDetails();
			Annonce annonce = request.getAnnonce();

			annonceService.saveAnnonceWithDetails(annonce, details);

			response.addMessage("save", "L'annonce a ete enregistrers");

			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateAnnonce(@RequestBody Annonce annonce, @PathVariable("id") String id) {
		Response response = new Response();
		try {
			annonce.setId(id);
			Annonce updatedAnnonce = annonceService.updateAnnonce(annonce);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Annonce mis a jour")
					.addData("updatedAnnonce", updatedAnnonce));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteAnnonce( @PathVariable("id") String id ){
		Response response = new Response();
		try{
			annonceService.deleteAnnonce( id );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Annonce suppression" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/nonValider")
	public ResponseEntity<?> getAnnoncesNonValider() throws Exception{
		try{
			Annonce[] annonces = annonceService.findAllAnnoncesEnAttente().toArray( new Annonce[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( annonces );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/validate/{id}")
	public ResponseEntity<Response> validateAnnonce(@RequestBody ValidateAnnonce validate, @PathVariable("id") String id) {
		Response response = new Response();
		try {
			annonceService.saveValidateAnnonce(id, validate);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Annonce mis à jour, validee!"));
		} catch (Exception e) {
			e.printStackTrace();
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/validate")
	public ResponseEntity<?> getValidateAnnonces() throws Exception{
		try{
			Annonce[] annonces = annonceService.findAllValidatedAnnonces().toArray( new Annonce[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( annonces );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PutMapping("/vendu/{id}")
	public ResponseEntity<Response> annonceVendu(@RequestBody AnnonceVendus vendu, @PathVariable("id") String id) {
		Response response = new Response();
		try {
			annonceService.saveAnnonceVendu(id, vendu);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Annonce mis à jour, vendu!"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

// 	@GetMapping("/vendu")
// 	public ResponseEntity<?> getAnnoncesVendus() throws Exception{
// 		try{
// 			AnnonceVendus[] annonces = annonceService.findAllVenduAnnonces().toArray( new AnnonceVendus[0] );
// 			return ResponseEntity.status( HttpStatus.OK ).body( annonces );
// 		}catch( Exception exception ){
// 			exception.printStackTrace();
// 			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
// 		}
// 	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/favoris/{user}")
	public ResponseEntity<?> getAnnoncesFavoris(@PathVariable("user") String user) throws Exception{
		try{
			Users userP = new Users();
			userP.setId(user);
			AnnonceFavories[] annonces = annonceService.findAllAnnoncesFavories(userP).toArray( new AnnonceFavories[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( annonces );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@PreAuthorize("hasRole('USER')")
	@PutMapping("/favoris/{id}")
	public ResponseEntity<Response> favoriteAnnonce(@RequestBody AnnonceFavories favories, @PathVariable("id") String id) {
		Response response = new Response();
		try {
			annonceService.saveAnnonceFavories(id, favories);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Annonce mis à jour, en favoris!"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasRole('USER')")
	@PutMapping("/defavoris/{id}")
	public ResponseEntity<Response> defavorieAnnonce(@PathVariable("id") String id) {
		Response response = new Response();
		try {
			annonceService.DefavoriseAnnonce(id);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Annonce mis à jour, en defavoris!"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	// @PreAuthorize("hasRole('USER')")
	@PostMapping("/search")
	public ResponseEntity<?> advancedSearch(@RequestBody SearchedElements elements) {
		try{
			Annonce[] annonces = annonceService.getAnnoncesMatch(elements).toArray( new Annonce[0] );
			return ResponseEntity.status(HttpStatus.OK).body(annonces);
		} catch(Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}


}