package com.example.carws.service;

import org.springframework.stereotype.*;

import com.example.carws.model.users.Messagerie;
import com.example.carws.repository.MessagerieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.List;

import org.springframework.beans.factory.annotation.*;

@Service
public class MessagerieService {
    @Autowired
    MessagerieRepository messagingRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public void nouveauMessage(Messagerie message) throws Exception {
        messagingRepository.save(message);
    }

    public List<Messagerie> getDiscussions(String idEnvoyeur, String idReceveur) {
        this.setStatus(idReceveur, idEnvoyeur, 20, 1);
        Criteria criteria = new Criteria().orOperator(
                Criteria.where("idEnvoyeur").is(idEnvoyeur).and("idReceveur").is(idReceveur),
                Criteria.where("idEnvoyeur").is(idReceveur).and("idReceveur").is(idEnvoyeur)
        );
        Query query = new Query(criteria).with(Sort.by(Sort.Direction.ASC, "dateHeureEnvoie"));
        return mongoTemplate.find(query, Messagerie.class);
    }

    public void setStatus(String idEnvoyeur, String idReceveur, int status, int avant) {
        Query query = new Query(Criteria.where("idEnvoyeur").is(idEnvoyeur).and("idReceveur").is(idReceveur).and("status").is(avant));
        Update update = new Update().set("status", status);
        mongoTemplate.updateFirst(query, update, Messagerie.class);
        System.out.println("Set status teto");
    }
}
