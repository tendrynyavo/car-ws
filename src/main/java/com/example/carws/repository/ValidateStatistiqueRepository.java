package com.example.carws.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.carws.model.statistics.*;
import java.util.*;

public interface ValidateStatistiqueRepository extends JpaRepository< ValidateStatistique, Integer >{

	@Query( value = "select * from get_validate_annonce_by_year(:year)", nativeQuery = true )
	List<ValidateStatistique> getStatisticByYear(@Param("year") Integer year);

}