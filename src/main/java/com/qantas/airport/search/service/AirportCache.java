package com.qantas.airport.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qantas.airport.search.dao.AirportFilterDao;
import com.qantas.airport.search.model.Airport;

/**
 * 
 *	This cache implementation has many shortcomings. It is only a static variable which relies on the fact
 *	that Spring keeps it alive a singleton.
 * 
 *	It doesn't have TTL, etc.
 */
@Component
public class AirportCache {
	
	@Autowired
	AirportFilterDao airportDao;
	private static List<Airport> cache = new ArrayList<>();
	
	public List<Airport> get(){
		if(cache == null || cache.size() == 0){
			cache = airportDao.getAll();
		}
		return cache;
	}
}
