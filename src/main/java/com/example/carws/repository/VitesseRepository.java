package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;

public interface VitesseRepository extends JpaRepository< Vitesse, Integer >{
	List<Vitesse> findByDeletedFalse();
	Vitesse findByIdAndDeletedFalse( Integer id );
}