package com.example.carws.service;

import org.springframework.stereotype.*;

import com.example.carws.model.users.Messagerie;
import com.example.carws.repository.MessagerieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

@Service
public class MessagerieService {
    @Autowired
    MessagerieRepository messagingRepository;

    public void nouveauMessage(Messagerie message) throws Exception {
        messagingRepository.save(message);
    }

    public List<Messagerie> getDiscussion(String idEnvoyeur, String idReceveur) {
        return null;
    }
}
