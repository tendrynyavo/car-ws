package com.example.carws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carws.model.users.Messagerie;

public interface MessagerieRepository extends MongoRepository<Messagerie, Integer> {
    
}
