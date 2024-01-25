package com.example.carws.service;

import com.example.carws.repository.UsersRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.example.carws.model.users.Users;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void inscription(Users users) throws Exception {
        usersRepository.save(users);
    }

    public Users login(String id) throws Exception {
        Users user = usersRepository.findById(id).orElse(null);
        if (user == null)
            throw new Exception("Utilisateur non trouvé.");
        return user;
    }

    // public String authenticateUser(String email, String password) throws Exception {
    //     try {
    //         FirebaseToken token = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).getResult();
    //         return token.getUid();
    //     } catch (FirebaseAuthException e) {
    //         throw new Exception("Erreur d'authentification", e);
    //     }
    // }

    // public String registerUser(String email, String password) throws Exception {
    //     try {
    //         FirebaseToken token = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).getResult();
    //         return token.getUid();
    //     } catch (FirebaseAuthException e) {
    //         throw new Exception("Erreur d'inscription", e);
    //     }
    // }

}
