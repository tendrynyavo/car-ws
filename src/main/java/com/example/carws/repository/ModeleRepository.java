package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;

public interface ModeleRepository extends JpaRepository< Modele, Integer >{
	List<Modele> findByDeletedFalse();
	Modele findByIdAndDeletedFalse( Integer id );
}