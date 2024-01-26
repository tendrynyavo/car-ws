package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.carws.model.statistics.*;
import java.util.*;

public interface StatisticRepository extends JpaRepository< Statistique, String >{
	@Query( value = "select *, 0 as annee from v_stats_month", nativeQuery = true )
	List<Statistique> getStatisticByMonth();
}