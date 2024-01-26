package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;

public interface VitesseRepository extends JpaRepository< Vitesse, String >{
	List<Vitesse> findByDeletedFalse();
	Vitesse findByIdAndDeletedFalse( String id );
}