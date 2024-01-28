/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.carws.controller.categorie;

import com.example.carws.model.primaire.Couleur;
import com.example.carws.response.Response;
import com.example.carws.service.CouleurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/couleurs")
public class CouleurController {
          @Autowired CouleurService service;
          
          @GetMapping()
          public ResponseEntity<?> list() {
                    Response response = new Response();
                    try{
                              List<Couleur> couleurs = service.getAll();
                              return ResponseEntity.ok().body( couleurs );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( e.getMessage() );
                    }

          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get( @PathVariable("id") String id ) {
                    Response response = new Response();
                    try{
                              Couleur couleurs = service.getCouleur(id);
                              return ResponseEntity.ok().body( response.addData( "data", couleurs) );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }

          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @PutMapping("/{id}")
          public ResponseEntity<Response> put(@PathVariable String id, @RequestBody Couleur input) {
                     Response response = new Response();
                    try{
                              input.setId(id);
                             service.updateCouleur(input);
                              return ResponseEntity.ok().body( response.addData( "message", "Couleur modifié") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @PostMapping
          public ResponseEntity<Response> post(@RequestBody Couleur input) {
                    Response response = new Response();
                    try{
 
                             service.saveCouleur(input);
                              return ResponseEntity.ok().body( response.addData( "message", "Couleur ajouté") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @DeleteMapping("/{id}")
          public ResponseEntity<?> delete(@PathVariable String id) {
                    Response response = new Response();
                    try{
                             service.deleteCouleur(id);
                              return ResponseEntity.ok().body( response.addData( "message", "Couleur supprimé") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
}
