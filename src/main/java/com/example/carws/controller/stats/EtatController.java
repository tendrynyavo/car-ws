/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.example.carws.controller.stats;

import com.example.carws.model.primaire.Etat;
import com.example.carws.response.Response;
import com.example.carws.service.EtatService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/etats")
public class EtatController {
          
          @Autowired EtatService service;
          
          @GetMapping()
          public ResponseEntity<?> list() {
                    Response res = new Response();
                    try{
                              List<Etat> etats = service.getAll();
                              return  ResponseEntity.ok().body(etats);
                    }catch(Exception e){
                              e.printStackTrace();
                              return  ResponseEntity.badRequest().body(e.getMessage());
                    }
          }
          
          @GetMapping("/{id}")
          public ResponseEntity<Response> get(@PathVariable Integer id) {
                     Response res = new Response();
                    try{
                              Etat etat = service.get( id );
                              return  ResponseEntity.ok().body(res.addData("data", etat));
                    }catch(Exception e){
                              e.printStackTrace();
                              return  ResponseEntity.badRequest().body(res.addError("error", e.getMessage()));
                    }
          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @PutMapping("/{id}")
          public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody Etat input) {
                    Response res = new Response();
                    try{
                              input.setValeur(id);
                              service.update(input);
                              return  ResponseEntity.ok().body(res.addMessage("success", "Etat modifié"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return  ResponseEntity.badRequest().body(res.addError("error", e.getMessage()));
                    }
          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @PostMapping
          public ResponseEntity<?> post(@RequestBody Etat input) {
                    Response res = new Response();
                    try{
//                              input.setValeur(id);
                              service.save(input);
                              return  ResponseEntity.ok().body(res.addMessage("success", "Etat ajouté"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return  ResponseEntity.badRequest().body(res.addError("error", e.getMessage()));
                    }
          }
          
          @PreAuthorize("hasRole('ADMIN')")
          @DeleteMapping("/{id}")
          public ResponseEntity<?> delete(@PathVariable Integer id) {
                    Response res = new Response();
                    try{
                              
                              service.delete(id);
                              return  ResponseEntity.ok().body(res.addMessage("success", "Etat supprimé"));
                    }catch(Exception e){
                              e.printStackTrace();
                              return  ResponseEntity.badRequest().body(res.addError("error", e.getMessage()));
                    }
          }
          
}
