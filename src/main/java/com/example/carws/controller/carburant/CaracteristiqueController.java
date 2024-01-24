/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.controller.carburant;

import com.example.carws.model.primaire.Caracteristique;
import com.example.carws.response.Response;
import com.example.carws.service.CaracteristiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sarobidy
 */
@RestController
@RequestMapping("/api/caracteristiques")
public class CaracteristiqueController {
          @Autowired CaracteristiqueService service;
          
          @GetMapping
          public ResponseEntity<Response> getAll(){
                    Response response = new Response();
                    try{
                       Caracteristique[] caracteristiques = service.getCaracteristiques();
                       return ResponseEntity.ok().body( response.addData("data", caracteristiques) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( response.addError("error", e.getMessage()) );
                    }
          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get( @PathVariable(value = "id") String id ){
                    Response response = new Response();
                    try{
                              Caracteristique c = service.getCaracteristique(id);
                              return ResponseEntity.ok().body( response.addData( "data" , c ) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error", e.getMessage()) );
                    }
          }
          
          @PostMapping
          public ResponseEntity<Response> save( @RequestBody Caracteristique c ){
                    Response response = new Response();
                    try{
                              service.saveCaracteristique(c);
                              return ResponseEntity.ok().body( response.addMessage("success", "caracteristiques ajoutées") );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error", e.getMessage()) );
                    }
          }
          
          @PutMapping("/{id}")
          public ResponseEntity<Response> update(@PathVariable("id") String id , @RequestBody Caracteristique c){
                    c.setId(id);
                    Response response = new Response();
                    try{
                              service.updateCaracteristique(c);
                              return ResponseEntity.ok().body( response.addMessage("success", "Caractéristique mis à jour" ) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error", e.getMessage()) );
                    }
          }
          
          @DeleteMapping("/{id}")
          public ResponseEntity<Response> delete( @PathVariable String id ){
                    Response response = new Response();
                    try{
                              service.deleteCaracteristique(id);
                              return ResponseEntity.ok().body( response.addMessage("success", "Caractéristique supprimé" ) );
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body( response.addError("error", e.getMessage()) );
                    }
          }
          
}
