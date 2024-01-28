package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.carws.model.primaire.*;

public interface ColoriageRepository extends JpaRepository< Coloriage, String > {
	@Query("SELECT c FROM Coloriage c WHERE c.voiture.id = :voitureId ORDER BY c.dateApplication DESC LIMIT 1")
    Coloriage findLatestColor(@Param("voitureId") String voitureId);

}