package com.example.carws.service;

import com.example.carws.repository.StatisticRepository;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import com.example.carws.model.primaire.*;
import com.example.carws.model.statistics.*;
import com.example.carws.exception.*;

@Service
public class StatistiqueService{

	@Autowired StatisticRepository repository;
	
	public List<Statistique> getStatisticMonthly() throws Exception{
		return repository.getStatisticByMonth();
	}

}