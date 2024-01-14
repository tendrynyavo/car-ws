package com.example.carws.controller.users;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.token.Token;
import com.example.carws.model.users.Users;
import com.example.carws.service.UsersService;
import com.example.carws.response.*;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

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
            // response.addData("token", users);
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
}