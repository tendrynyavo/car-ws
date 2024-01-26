package com.example.carws.service;

import com.example.carws.repository.StatisticRepository;
import com.example.carws.repository.ValidateStatistiqueRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.statistics.*;

@Service
public class StatistiqueService{

	@Autowired StatisticRepository repository;

	@Autowired ValidateStatistiqueRepository validateRepository;
	
	public List<Statistique> getStatisticMonthly() throws Exception{
		return repository.getStatisticByMonth();
	}

	public List<ValidateStatistique> getValidateStatisticsByYear(Integer year) throws Exception {
		return validateRepository.getStatisticByYear(year);
	}

}