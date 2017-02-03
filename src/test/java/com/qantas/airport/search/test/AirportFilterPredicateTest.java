package com.qantas.airport.search.test;

import org.junit.Assert;
import org.junit.Test;

import com.qantas.airport.search.model.Airport;
import com.qantas.airport.search.model.Country;
import com.qantas.airport.search.model.FilterCriteria;
import com.qantas.airport.search.service.AirportFilterPredicate;

public class AirportFilterPredicateTest {

	@Test
	public void test_some_criteria(){
		
		AirportFilterPredicate p = new AirportFilterPredicate(new FilterCriteria("", "123", true, false));
		Assert.assertTrue(p.evaluate(new Airport(null,"123", true, false)));
		Assert.assertFalse(p.evaluate(new Airport(null,"123", false, false)));
		Assert.assertFalse(p.evaluate(new Airport(null,"13", false, false)));
		Assert.assertFalse(p.evaluate(new Airport(null,"13", null, false)));
	}

	@Test
	public void test_empty_criteria_all_must_pass(){
		
		AirportFilterPredicate p = new AirportFilterPredicate(new FilterCriteria("", "", null, null));
		Assert.assertTrue(p.evaluate(new Airport(null,"123", true, false)));
		Assert.assertTrue(p.evaluate(new Airport(null,"123", false, false)));
		Assert.assertTrue(p.evaluate(new Airport(null,"13", false, false)));
		Assert.assertTrue(p.evaluate(new Airport(null,"13", null, false)));
	}

	@Test
	public void test_country(){
		
		AirportFilterPredicate p = new AirportFilterPredicate(new FilterCriteria("iran", "", null, null));
		Assert.assertTrue(p.evaluate(new Airport(new Country("iran", ""),"123", true, false)));
	}

}
