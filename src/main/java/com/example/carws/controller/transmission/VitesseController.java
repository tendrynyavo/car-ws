package com.example.carws.controller.transmission;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.carws.model.primaire.Vitesse;
import com.example.carws.service.VitesseService;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/vitesses")
public class VitesseController {

	@Autowired
	VitesseService vitesseService;

	@GetMapping
	public ResponseEntity<?> getCategories() throws Exception {
		try {
			Vitesse[] Vitesses = null;
			Vitesses = vitesseService.getAllVitesses().toArray(new Vitesse[0]);
			return ResponseEntity.status(HttpStatus.OK).body(Vitesses);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getVitesse(@PathVariable("id") String id) throws Exception {
		try {
			Vitesse vitesse = vitesseService.getVitesse(id);
			Response response = new Response();
			response.addData("items", vitesse);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response().addError("exception", e.getMessage()));
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Response> addVitesse(@RequestBody Vitesse vitesse) throws Exception {
		Response response = new Response();
		try {
			vitesseService.saveVitesse(vitesse);
			response.addMessage("save", "La Vitesse a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateVitesse(@RequestBody Vitesse vitesse,
			@PathVariable("id") String id) {
		Response response = new Response();
		try {
			vitesse.setId(id);
			vitesseService.updateVitesse(vitesse);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Boite à vitesse mis a jour"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteVitesse(@PathVariable("id") String id) {
		Response response = new Response();
		try {
			vitesseService.deleteVitesse(id);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Marque supprimé"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}