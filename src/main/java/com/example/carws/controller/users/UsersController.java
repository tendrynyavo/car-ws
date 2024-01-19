package com.example.carws.controller.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.token.Token;
import com.example.carws.model.users.Messagerie;
import com.example.carws.model.users.Users;
import com.example.carws.service.MessagerieService;
import com.example.carws.service.UsersService;
import com.example.carws.response.*;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @Autowired
    MessagerieService messagerieService;

    @GetMapping("/inscription_valide/{date}")
    public ResponseEntity<Response> isInscriptionValid(@PathVariable("date") String date) throws Exception {
        try {
            Users users = new Users();
            users.setDateDeNaissance(date);
            Response response = new Response();
            response.addData("valide", "Inscription valide");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            System.out.println("Erreur: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", exception.getMessage()));
        }
    }

    @PostMapping("inscription")
    public ResponseEntity<Response> inscription(@RequestBody Users users) throws Exception {
        try {
            usersService.inscription(users);
            Response response = new Response();
            response.addData("valide", "Le nouveau utilisateur a ete enregistre avec succès");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", e.getMessage()));
        }
    }

    @PostMapping("login")
    public ResponseEntity<Response> login(@RequestBody Users users) throws Exception {
        try {
            users = usersService.login(users.getId());
            String token = new Token().generateJwt(users);
            Response response = new Response();
            response.addData("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", e.getMessage()));
        }
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<Response> checkTokenValid(@PathVariable("token") String token) throws Exception {
        try {
            Claims claims = new Token().verify(token);
            Response response = new Response();
            response.addData("user", claims);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            System.out.println("Erreur: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", exception.getMessage()));
        }
    }

    @PostMapping("messagerie")
    public ResponseEntity<Response> nouveauMessage(@RequestBody Messagerie messagerie) {
        try {
            Claims claims = new Token().verify(messagerie.getIdEnvoyeur());
            String idEnvoyeur = claims.get("id", String.class);
            messagerie.setIdEnvoyeur(idEnvoyeur);
            messagerieService.nouveauMessage(messagerie);
            Response response = new Response();
            response.addData("valide", "Message envoye");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            System.out.println("Erreur: " + exception.getMessage());
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", exception.getMessage()));
        }
    }

    @PostMapping("discussions")
    public ResponseEntity<Response> discussions(@RequestBody Messagerie messagerie) {
        try {
            Claims claims = new Token().verify(messagerie.getIdEnvoyeur());
            String idEnvoyeur = claims.get("id", String.class);
            List<Messagerie> discussions = messagerieService.getDiscussions(idEnvoyeur, messagerie.getIdReceveur());
            Response response = new Response();
            response.addData("discussions", discussions);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            System.out.println("Erreur: " + exception.getMessage());
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", exception.getMessage()));
        }
    }

    @PostMapping("StatusVu")
    public ResponseEntity<Response> setStatusVu(@RequestBody Messagerie messagerie) {
        try {
            Claims claims = new Token().verify(messagerie.getIdEnvoyeur());
            String idEnvoyeur = claims.get("id", String.class);
            messagerieService.setStatus(messagerie.getIdReceveur(), idEnvoyeur, 20, 1);
            Response response = new Response();
            response.addData("status", "Modification effectue");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception exception) {
            System.out.println("Erreur: " + exception.getMessage());
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new Response().addError("exception", exception.getMessage()));
        }
    }

}