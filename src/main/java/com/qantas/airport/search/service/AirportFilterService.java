package com.qantas.airport.search.service;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qantas.airport.search.model.Airport;
import com.qantas.airport.search.model.FilterCriteria;

/**
 * 
 * This service gets the list of airports from cache and runs them through the filter
 *
 */
@Component
public class AirportFilterService {

	@Autowired
	AirportCache airportCache;
	
	public Collection<Airport> filter(FilterCriteria filter) {
		List<Airport> airports =  airportCache.get();
		return CollectionUtils.select(airports, new AirportFilterPredicate(filter) );
	}
}
