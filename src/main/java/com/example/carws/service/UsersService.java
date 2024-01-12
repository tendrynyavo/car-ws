package com.example.carws.service;

import com.example.carws.repository.UsersRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.exception.*;
import com.example.carws.model.users.Users;

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

}