package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;
public interface CarburantRepository extends JpaRepository< Carburant, String >{
	List<Carburant> findByDeletedFalse();
	Carburant findByIdAndDeletedFalse( String id );
}