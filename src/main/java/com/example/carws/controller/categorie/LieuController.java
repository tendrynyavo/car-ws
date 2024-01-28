/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.carws.controller.categorie;

//import com.example.carws.configuration.RelationRepository;
import com.example.carws.model.primaire.Lieu;
import com.example.carws.response.Response;
import com.example.carws.service.LieuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/lieus")
public class LieuController {
          
          @Autowired LieuService service;
//          @Autowired RelationRepository repo;
          
          @GetMapping()
          public ResponseEntity<?> list() {
                    Response response = new Response();
                    try{
                              List<Lieu> lieus = service.list();
                              return ResponseEntity.ok().body( lieus );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( e.getMessage() );
                    }

          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get(@PathVariable String id) {
                    Response response = new Response();
                    try{
                              Lieu couleurs = service.get( id );
                              return ResponseEntity.ok().body( response.addData( "data", couleurs) );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          @PutMapping("/{id}")
          public ResponseEntity<Response> put(@PathVariable String id, @RequestBody Lieu input) {
                    Response response = new Response();
                    try{
                              input.setId(id);
                              service.update(input);
                              return ResponseEntity.ok().body( response.addData( "message", "Lieu modifié") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          @PostMapping
          public ResponseEntity<Response> post(@RequestBody Lieu input) {
                    Response response = new Response();
                    try{
//                              input.setId(id);
                              service.save(input);
                              return ResponseEntity.ok().body( response.addData( "message", "Lieu ajouté") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          @DeleteMapping("/{id}")
          public ResponseEntity<?> delete(@PathVariable String id) {
                    Response response = new Response();
                    try{
//                              input.setId(id);
                              service.delete( id );
                              return ResponseEntity.ok().body( response.addData( "message", "Lieu supprimé") );
                    }catch(Exception e){
                              e.getMessage();
                              return ResponseEntity.badRequest().body( response.addError( "error", e.getMessage() ) );
                    }
          }
          
          
          
}
