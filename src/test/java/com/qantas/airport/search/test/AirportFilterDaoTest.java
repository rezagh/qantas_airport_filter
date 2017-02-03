package com.qantas.airport.search.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qantas.airport.search.dao.AirportFilterDao;
import com.qantas.airport.search.model.Airport;

/**
 * This is more of an integration test
 *	
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportFilterDaoTest {

	@Autowired
	AirportFilterDao dao;
	
    @Test
    public void test_GET() {
    
    	List<Airport> airports = dao.getAll();
    	Assert.assertNotNull(airports);
    	Assert.assertTrue(airports.size() != 0);
    }
}