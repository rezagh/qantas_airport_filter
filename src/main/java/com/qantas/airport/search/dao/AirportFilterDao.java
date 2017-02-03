package com.qantas.airport.search.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qantas.airport.search.model.Airport;
import com.qantas.airport.search.model.Airports;

@Component
public class AirportFilterDao {
	
	//TODO these should go to a property file
	private final String AIRPORTS_URL= "https://www.qantas.com.au/api/airports";
	private final String ACCEPT_HEADER_VALUE="application/vnd.qantas.airports.v1+json";
	private final String ACCEPT_HEADER="Accept";
	
	Logger log = Logger.getLogger(AirportFilterDao.class);

	public List<Airport> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        
        log.info("Getting the massive list of airports.");
        
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT_HEADER, ACCEPT_HEADER_VALUE);
        HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);        
        
        try{
        	ResponseEntity<Airports> airports = restTemplate.exchange(AIRPORTS_URL, HttpMethod.GET,entity,Airports.class);
            log.info("List of airport retrieved.");

            return validateAndRespond(airports);
        }catch (Throwable t){
        	log.error("Exception during REST exchange", t);
        	return Collections.EMPTY_LIST;
        }
    }

	private List<Airport> validateAndRespond(ResponseEntity<Airports> airports) {
        if (airports == null || 
        		airports.getBody() == null || 
        		airports.getBody().getAirports() == null || 
        		airports.getBody().getAirports().size() == 0){
        
        	log.error("No airports found! Response empty.");

        	//Other option is to send an exception back and translate it to HTTP error codes
        	return Collections.EMPTY_LIST;
        }
        
        return airports.getBody().getAirports();
	}
}