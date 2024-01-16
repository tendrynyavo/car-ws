package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.voiture.* ;
// import java.util.*;

public interface VoitureRepository extends JpaRepository< Voiture, Integer >{

}