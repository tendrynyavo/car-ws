package com.example.carws.controller.stats;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.carws.model.statistics.*;
import com.example.carws.service.*;

import com.example.carws.response.*;

@RestController
@RequestMapping("/api/stats")
public class StatisticController{
 	
 	@Autowired StatistiqueService service;

	@PreAuthorize("hasRole('ADMIN')")
 	@GetMapping("/monthly")
	public ResponseEntity<Response> getMonthlyStatistics() {
		Response response = new Response();
		try{
			Statistique[] monthly = service.getStatisticMonthly().toArray( new Statistique[0] );
			String[] mois = new Statistique().getMonthFromStatistics(monthly);
			response.addData( "statistics" , monthly );
			response.addData( "mois" , mois );
			
			return ResponseEntity.status( HttpStatus.OK ).body( response );
		}catch (Exception e) {
			e.printStackTrace();
			response.addError( "error" , e.getMessage() );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(response);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/byYear/{year}")
	public ResponseEntity<Response> getStatisticsByYear(@PathVariable("year") Integer year) {
		Response response = new Response();
		try{

			ValidateStatistique[] statsByYear = service.getValidateStatisticsByYear(year).toArray(new ValidateStatistique[0]);
			String[] mois = new ValidateStatistique().getMonths(statsByYear);
			response.addData( "statistics" , statsByYear );
			response.addData( "months" , mois );

			System.out.println(statsByYear[2].getMois());
			
			return ResponseEntity.status( HttpStatus.OK ).body( response );

		}catch (Exception e) {
			e.printStackTrace();
			response.addError( "error" , e.getMessage() );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(response);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/vente/{annee}")
	public ResponseEntity<Response> getStatistiqueVenteParAn(@PathVariable("annee") String annee) {
		Response response = new Response();
		try{
			int[][] statsParAn = this.service.getStatistiqueVenteParAn(annee);
			response.addData( "statistics" , statsParAn );

			System.out.println("Fevrier: " + statsParAn[1][1]);
			
			return ResponseEntity.status( HttpStatus.OK ).body( response );

		}catch (Exception e) {
			e.printStackTrace();
			response.addError( "error" , e.getMessage() );
			return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(response);
		}
	}

}