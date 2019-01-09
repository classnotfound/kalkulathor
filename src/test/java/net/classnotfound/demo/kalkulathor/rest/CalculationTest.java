package net.classnotfound.demo.kalkulathor.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.classnotfound.demo.kalkulathor.operation.Oper;

@RunWith(SpringRunner.class)
@WebMvcTest(KalkController.class)
public class CalculationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void testAdd() throws Exception {
		String json = 
				new ObjectMapper().writeValueAsString(
				  		Calculation.builder()
				  		.a(5)
				  		.b(6)
				  		.oper(Oper.ADD)
				  		.build());
		mvc.perform(get("/api/calculate")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(json))
			      .andExpect(status().isOk())
			      .andExpect(content().string("11"));
	}

}
