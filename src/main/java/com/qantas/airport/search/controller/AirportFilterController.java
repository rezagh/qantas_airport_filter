package com.qantas.airport.search.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qantas.airport.search.model.Airport;
import com.qantas.airport.search.model.FilterCriteria;
import com.qantas.airport.search.service.AirportFilterService;

/**
 * 
 * The controller that exposes REST api
 * 
 *
 */
@RestController
public class AirportFilterController {

	@Autowired
	AirportFilterService filterService;
	
	Logger log = Logger.getLogger(AirportFilterController.class);


    /**
     * Filter airports by country, airport code, international, domestic airports
     * All params are optional
     *  
     */
  @RequestMapping("/search")
    public Collection<Airport> airportSearch( @RequestParam(value="country", defaultValue="", required = false) String country ,
						    		@RequestParam(value="code", defaultValue="", required = false) String code,
						    		@RequestParam(value="intl", defaultValue="", required = false) String intl,
						    		@RequestParam(value="domestic", defaultValue="", required = false) String domestic ) {

    	return filterService.filter(vaidateRequest(country, code, intl, domestic));
    }
  
  
  /**
   *	 we could do better validation here. Depending on requirements we could return HTTP error codes too.
   */
  public FilterCriteria vaidateRequest(String country, String code, String intl, String domestic){
	  FilterCriteria filter = new FilterCriteria();
	  	
	  	filter.setCode(code);
	  	filter.setCountry(country);
	  	
	  	if (intl.equalsIgnoreCase("true") || intl.equals("1")){
	  		filter.setIntl(true);
	  	}else if (intl.equalsIgnoreCase("false") || intl.equals("0")){
	  		filter.setIntl(false);
	  	} else{
	  		filter.setIntl(null);
	  	}
	  	
	  	if (domestic.equalsIgnoreCase("true") || domestic.equals("1")){
	  		filter.setDomestic(true);
	  	} else if (domestic.equalsIgnoreCase("false") || domestic.equals("0")){
	  		filter.setDomestic(false);
	  	} else {
	  		filter.setDomestic(null);
	  	}
	  	
	  	return filter;
  }
  
  
}
