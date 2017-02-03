package com.qantas.airport.search.service;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.StringUtils;

import com.qantas.airport.search.model.Airport;
import com.qantas.airport.search.model.FilterCriteria;

/**
 *	We are assuming filter parameters operate as logical AND not OR.
 * 
 *
 */
public class AirportFilterPredicate implements Predicate<Airport> {
	FilterCriteria filter;
	
	public AirportFilterPredicate(FilterCriteria filter) {
		this.filter = filter;
	}
	
	@Override
	public boolean evaluate(Airport airport) {
		
		if (StringUtils.isNotBlank(filter.getCode()) && !filter.getCode().equalsIgnoreCase(airport.getCode())){
			return false;
		}
		
		if (filter.getIntl() != null && !filter.getIntl().equals(airport.isInternational_airport())){
			return false;
		}

		if (filter.getDomestic() != null && !filter.getDomestic().equals(airport.isRegional_airport())){
			return false;
		}

		
		boolean countryNotBlank = StringUtils.isNotBlank(filter.getCountry());
		
		//country is checked against both country code and display name.
		if (countryNotBlank){
			boolean countryCodeNotMatch = !filter.getCountry().equalsIgnoreCase(airport.getCountry().getCode());
			boolean countryNameNotMatch = !filter.getCountry().equalsIgnoreCase(airport.getCountry().getDisplay_name());
			if(countryCodeNotMatch && countryNameNotMatch) return false;
		}

		return true;
	}
}
