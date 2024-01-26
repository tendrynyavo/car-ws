package com.example.carws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carws.model.users.Messagerie;

public interface MessagerieRepository extends MongoRepository<Messagerie, Integer> {
    // @Query("{ $or: [ { 'idEnvoyeur': ?0, 'idReceveur': ?1 }, { 'idEnvoyeur': ?1, 'idReceveur': ?0 } ], $orderby: { 'dateHeureEnvoie': 1 } }")
    // List<Messagerie> getDiscussions(String idEnvoyeur, String idReceveur);
}
