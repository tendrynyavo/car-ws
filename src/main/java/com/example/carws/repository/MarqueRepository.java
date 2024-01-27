package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;

public interface MarqueRepository extends JpaRepository< Marque, String >{
//	List<Marque> findByDeletedFalse();
//	Marque findById( String id );
}