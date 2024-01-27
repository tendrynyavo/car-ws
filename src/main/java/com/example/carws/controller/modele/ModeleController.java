package com.example.carws.controller.modele;

import com.example.carws.model.primaire.Categorie;
import com.example.carws.model.primaire.Marque;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.primaire.Modele;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.service.ModeleService;

import com.example.carws.response.*;
import com.example.carws.service.MarqueService;
import com.example.carws.service.model.ModelCategorieService;
import java.util.List;

@RestController
@RequestMapping("/api/modeles")
public class ModeleController{

	@Autowired ModeleService modeleService;
          @Autowired ModelCategorieService modeleCategorieService;
          @Autowired MarqueService marqueService;
          
	@GetMapping
	public ResponseEntity<?> getModeles() throws Exception{
		Response r = new Response();
              try{
			Modele[] modeles = null;
			modeles = modeleService.getAllModeles().toArray( new Modele[0] );
                           List<Marque> marques = marqueService.getAllMarques();
                           r.addData("modeles" , modeles);
                           r.addData("marques" , marques);
			return ResponseEntity.status( HttpStatus.OK ).body( r );
		}catch( Exception exception ){
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( exception.getMessage() );
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getModele( @PathVariable("id") String id ) throws Exception{
		try{
			Modele modele = modeleService.getModele(id);
			Response response = new Response();
			response.addData( "items" , modele );
			return ResponseEntity.status(HttpStatus.OK).body( response );
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new Response().addError( "exception", e.getMessage() ) );
		}
	}

	@PostMapping
	public ResponseEntity<Response> addModele( @RequestBody Modele modele ) throws Exception{
		Response response = new Response();
		try{
			modeleService.saveModele( modele );
			response.addMessage("save", "Le modele a ete ajouter");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e){
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateModele( @RequestBody Modele modele, @PathVariable("id") String id ){
		Response response = new Response();
		try{
			modele.setId(id);
			modeleService.updateModele( modele );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "modele mis a jour" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteModele( @PathVariable("id") String id ){
		Response response = new Response();
		try{
			modeleService.deleteModele( id );
			return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Modele supprimé" ) );
		}catch (Exception e) {
			response.addError("error" , e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
		}
	}
    
//         @PostMapping( "/categories/{categorie}" )
//         public ResponseEntity<Response> addModelToCategory(@RequestBody Modele modele, @PathVariable("categorie") Integer categorie ){
//                   Response response = new Response();
//                   try{
//                             modeleCategorieService.addModelToCategory(modele.getId(), categorie);
//                             return ResponseEntity.status( HttpStatus.OK ).body( response.addMessage( "success" , "Modele ajouté à la catégorie" ) );
//                   }catch( Exception e ){
//                              response.addError("error" , e.getMessage());
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response );
//                   }
//                       
//         }
         
          @PostMapping( "/{id}/categories" )
          public ResponseEntity<?> addCategory( @PathVariable String id, @RequestBody Categorie categorie ){
                    Response response = new Response();
                    try{
                              this.modeleService.addCategoryToModel(id, categorie.getId());
                              
                              return ResponseEntity.ok().body( response.addMessage( "success", "Catégoie ajouté au modele" ) );
                              
                    }catch(Exception e){
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                    }
          }
          
          @PostMapping("/{id}/moteurs")
          public ResponseEntity<?> addEngine( @PathVariable String id, @RequestBody Moteur moteur ){
                    Response response = new Response();
                    try{
                              this.modeleService.addEngineToModel(id, moteur.getId());
                              
                              return ResponseEntity.ok().body( response.addMessage( "success", "Moteur ajouté au modele" ) );
                              
                    }catch(Exception e){
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                    }
          }

}