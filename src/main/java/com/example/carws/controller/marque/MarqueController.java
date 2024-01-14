package com.example.carws.controller.marque;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.Marque;
import com.example.carws.service.MarqueService;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/marque")
public class MarqueController {

	@Autowired
	MarqueService marqueService;

	@GetMapping
	public ResponseEntity<?> getMarques() throws Exception {
		try {
			Marque[] categories = null;
			categories = marqueService.getAllMarques().toArray(new Marque[0]);
			return ResponseEntity.status(HttpStatus.OK).body(categories);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getMarque(@PathVariable("id") Integer id) throws Exception {
		try {
			Marque marque = marqueService.getMarque(id);
			Response response = new Response();
			response.addData("items", marque);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response().addError("exception", e.getMessage()));
		}
	}

	@PostMapping
	public ResponseEntity<Response> addMarque(@RequestBody Marque marque) throws Exception {
		Response response = new Response();
		try {
			marqueService.saveMarque(marque);
			response.addMessage("save", "La marque a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateMarque(@RequestBody Marque marque, @PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			marque.setId(id);
			marqueService.updateMarque(marque);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Marque mis a jour"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteMarque(@PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			marqueService.deleteMarque(id);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Marque supprimé"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}