package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carws.model.primaire.*;
import java.util.*;

public interface TransmissionRepository extends JpaRepository< Transmission, Integer >{
	List<Transmission> findByDeletedFalse();
	Transmission findByIdAndDeletedFalse( Integer id );
}