package com.qantas.airport.search.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qantas.airport.search.controller.AirportFilterController;

/**
 * 
 * Much more tests could be added here!
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_GET() throws Exception {

        this.mockMvc.perform(get("/search")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("regional_airport")));
    	Assert.assertTrue(true);
    }

    @Test
    public void test_validation(){
    	AirportFilterController c = new AirportFilterController();
    	String country = "au";
    	String code = "xyz";
    	Assert.assertTrue(c.vaidateRequest("", "", "", "true").getDomestic());
    	Assert.assertFalse(c.vaidateRequest("", "", "false", "true").getIntl());
    	
    	Assert.assertEquals(c.vaidateRequest(country, "", "false", "true").getCountry(), country);
    	Assert.assertEquals(c.vaidateRequest(country, code, "false", "true").getCode(), code);
    }
}
