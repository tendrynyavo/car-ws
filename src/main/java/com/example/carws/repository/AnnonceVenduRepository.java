package com.example.carws.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.annonce.* ;
import com.example.carws.model.users.Users;

public interface AnnonceVenduRepository extends JpaRepository< AnnonceVendus, String >{
    List<AnnonceVendus> findAllByUser(Users user);
}