package com.example.carws.controller.transmission;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.Transmission;
import com.example.carws.service.TransmissionService;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/transmission")
public class TransmissionController {

	@Autowired
	TransmissionService transmissionService;

	@GetMapping
	public ResponseEntity<?> getCategories() throws Exception {
		try {
			Transmission[] transmissions = null;
			transmissions = transmissionService.getAllTransmissions().toArray(new Transmission[0]);
			return ResponseEntity.status(HttpStatus.OK).body(transmissions);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getTransmission(@PathVariable("id") Integer id) throws Exception {
		try {
			Transmission transmission = transmissionService.getTransmission(id);
			Response response = new Response();
			response.addData("items", transmission);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response().addError("exception", e.getMessage()));
		}
	}

	@PostMapping
	public ResponseEntity<Response> addTransmission(@RequestBody Transmission transmission) throws Exception {
		Response response = new Response();
		try {
			transmissionService.saveTransmission(transmission);
			response.addMessage("save", "La transmission a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateTransmission(@RequestBody Transmission transmission,
			@PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			transmission.setId(id);
			transmissionService.updateTransmission(transmission);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "transmission mis a jour"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteTransmission(@PathVariable("id") Integer id) {
		Response response = new Response();
		try {
			transmissionService.deleteTransmission(id);
			return ResponseEntity.status(HttpStatus.OK).body(response.addMessage("success", "Marque supprimé"));
		} catch (Exception e) {
			response.addError("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}