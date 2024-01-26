package com.example.carws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.carws.model.statistics.*;
import java.util.*;

public interface StatisticRepository extends JpaRepository<Statistique, String> {
	@Query(value = "select *, 0 as annee from v_stats_month", nativeQuery = true)
	List<Statistique> getStatisticByMonth();

	@Query(value = "select * from get_statistique_vente_mois(:annee);", nativeQuery = true)
	int[][] getStatistiqueVenteParAn(@Param("annee") int annee);
}