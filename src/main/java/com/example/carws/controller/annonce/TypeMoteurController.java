/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.carws.controller.annonce;

import com.example.carws.model.primaire.TypeMoteur;
import com.example.carws.response.Response;
import com.example.carws.service.TypeMoteurService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/types")
public class TypeMoteurController {
          @Autowired
          TypeMoteurService service;
          
          @GetMapping()
          public ResponseEntity<Response> list() {
                    Response response = new Response();
                    try{
                              TypeMoteur[] tms = service.findAll().toArray(new TypeMoteur[0]);
                              return ResponseEntity.ok().body(response.addData("data" , tms));
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                              
                    }
          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get(@PathVariable String id) {
                   Response response = new Response();
                    try{
                              TypeMoteur tms = service.get(id);
                              return ResponseEntity.ok().body(response.addData("data" , tms));
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));        
                    }
          }
          
          @PutMapping("/{id}")
          public ResponseEntity<Response> put(@PathVariable String id, @RequestBody TypeMoteur input) {
                    Response response = new Response();
                    try{
                              input.setId(id);
                              service.update(input);
                              return ResponseEntity.ok().body(response.addMessage("success" , "Le type de moteur a ete modifier"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                              
                    }
          }
          
          @PostMapping
          public ResponseEntity<Response> post(@RequestBody TypeMoteur input) {
                   Response response = new Response();
                    try{
                            
                              service.save(input);
                              return ResponseEntity.ok().body(response.addMessage("success" , "Le type de moteur a ete ajouter"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                              
                    }
          }
          
          @DeleteMapping("/{id}")
          public ResponseEntity<Response> delete(@PathVariable String id) {
                    Response response = new Response();
                    try{
//                              input.setId(id);
                              service.delete(id);
                              return ResponseEntity.ok().body(response.addMessage("success" , "Le type de moteur a ete supprimée"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return ResponseEntity.badRequest().body(response.addError("error" , e.getMessage()));
                              
                    }
          }
          
}
