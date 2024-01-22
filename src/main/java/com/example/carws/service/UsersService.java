package com.example.carws.service;

import com.example.carws.repository.UsersRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.example.carws.model.users.Users;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void inscription(Users users) throws Exception {
        String idUser = this.inscriptionFireBase(users.getMail(), users.getPassword());
        users.setId(idUser);
        usersRepository.save(users);
    }

    public Users login(String id) throws Exception {
        Users user = usersRepository.findById(id).orElse(null);
        if (user == null)
            throw new Exception("Utilisateur non trouvé.");
        return user;
    }

    public Users authentification(String email) throws Exception {
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
            Users user = usersRepository.findById(userRecord.getUid()).orElse(null);
            if (user == null)
                throw new Exception("Utilisateur non trouvé.");
            return user;
        } catch (Exception e) {
            throw new Exception("Aucun enregistrement d’utilisateur n’a été trouvé cette adresse e-mail fournie!");
        }
    }

    public String inscriptionFireBase(String email, String password) throws Exception {
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            return userRecord.getUid();
        } catch (Exception e) {
            throw new Exception("L’utilisateur avec l’adresse e-mail fournie existe déjà!");
        }
    }

}
