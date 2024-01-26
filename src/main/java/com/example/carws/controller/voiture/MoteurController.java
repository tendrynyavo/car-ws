/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.carws.controller.voiture;

import com.example.carws.model.primaire.Carburant;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.model.primaire.Vitesse;
import com.example.carws.response.Response;
import com.example.carws.service.MoteurService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author sarobidy
 */
@RestController
@RequestMapping("/api/moteurs")
public class MoteurController {
          @Autowired
          MoteurService service;
          
          @GetMapping()
          public ResponseEntity<Response> list() {
                    Response response = new Response();
                    try{
                              List<Moteur> moteurs = service.getAll();
                              return ResponseEntity.ok().body( response.addData("data" , moteurs) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error" , e.getMessage()) );
                    }
                    
          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get(@PathVariable String id) {
                    Response response = new Response();
                    try{
                              Moteur moteurs = service.get( id );
                              return ResponseEntity.ok().body( response.addData("data" , moteurs) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error" , e.getMessage()) );
                    }
          }
          
          @PutMapping("/{id}")
          public ResponseEntity<?> put(@PathVariable String id, @RequestBody Moteur input) {
                    Response response = new Response();
                    try{
                              input.setId( id );
                              service.update(input);
                              return ResponseEntity.ok().body( response.addMessage("success" , "Moteur modifiée") );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error" , e.getMessage()) );
                    }
          }
          
          @PostMapping
          public ResponseEntity<?> post(@RequestBody Moteur input) {
                    Response response = new Response();
                    try{
                              
                              service.save(input);
                              return ResponseEntity.ok().body( response.addMessage("success" , "Moteur ajoutée") );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error" , e.getMessage()) );
                    }
          }
          
          @DeleteMapping("/{id}")
          public ResponseEntity<?> delete(@PathVariable String id) {
                    Response response = new Response();
                    try{
                              
                              service.delete(id);
                              return ResponseEntity.ok().body( response.addMessage("success" , "Moteur supprimée") );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error" , e.getMessage()) );
                    }
          }
          
          @PostMapping( "/{id}/transmission" )
          public ResponseEntity<?> addTransmission( @PathVariable String id, @RequestBody Vitesse vitesse ){
                    Response response = new Response();
                    try{
                              this.service.addTransmission(vitesse.getId(), id);
                              
                              return ResponseEntity.ok().body( response.addMessage( "success", "Boite de vitesse ajouté au type de moteur" ) );
                              
                    }catch(Exception e){
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                    }
          }
          
           
          
}
