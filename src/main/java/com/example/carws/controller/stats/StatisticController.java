package com.example.carws.controller.stats;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.carws.model.statistics.*;
import com.example.carws.service.*;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/stats")
public class StatisticController{
 	
 	@Autowired StatistiqueService service;

 	@GetMapping("/monthly")
	public ResponseEntity<Response> getMonthlyStatistics() {
		Response response = new Response();
		try{
			Statistique[] monthly = service.getStatisticMonthly().toArray( new Statistique[0] );
			String[] mois = monthly[0].getMonthFromStatistics(monthly);
			response.addData( "statistics" , monthly );
			response.addData( "mois" , mois );
			
			return ResponseEntity.status( HttpStatus.OK ).body( response );
		}catch (Exception e) {
			e.printStackTrace();
			response.addError( "error" , e.getMessage() );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(response);
		}
	}

}