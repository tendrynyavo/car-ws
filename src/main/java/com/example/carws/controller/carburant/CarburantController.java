package com.example.carws.controller.carburant;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.*;
import com.example.carws.service.*;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/carburant")
public class CarburantController{

	@Autowired CarburantService carburantService;

	@GetMapping
	public ResponseEntity<?> getCarburants() throws Exception{
		try{
			Carburant[] carburants = null;
			carburants = carburantService.getAllCarburants().toArray( new Carburant[0] );
			return ResponseEntity.status( HttpStatus.OK ).body( carburants );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getCarburant( @PathVariable("id") String id ) throws Exception{
		try{
			Carburant carburant = carburantService.getCarburant(id);
			Response response = new Response();
			response.addData( "items" , carburant );
			return ResponseEntity.status(HttpStatus.OK).body( response );
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Response().addError( "exception", e.getMessage() ) );
		}
	}

	@PostMapping
	public ResponseEntity<Response> addCarburant( @RequestBody Carburant carburant ) throws Exception{
		Response response = new Response();
		try{
			carburantService.saveCarburant( carburant );
			response.addMessage("save", "Le type de carburant a ete enregistrer");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateCarburant( @RequestBody Carburant carburant, @PathVariable("id") String id ){
		Response response = new Response();
		try{
			carburant.setId(id);
			carburantService.updateCarburant( carburant );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Type de Carburant mise a jour" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteCarburant( @PathVariable("id") String id ){
		Response response = new Response();
		try{
			carburantService.deleteCarburant( id );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Type de carburant supprimé" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

}