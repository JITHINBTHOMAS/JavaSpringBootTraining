package com.ust.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.rest.model.Product;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
class ControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	public static final Product product = Product.builder()
			.id(1)
			.brand("Vaio Plus")
			.description("Smart Digital Mobile Phone")
			.qty(10)
			.price(20000)
			.build();
	private static final String APPLICATION_JSON_VALUE  = MediaType.APPLICATION_JSON_VALUE;
	ObjectMapper mapper = new ObjectMapper();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		
	}
	
	static void tearDownAfterClass() throws Exception{
		
	}
	
	@Test
	void saveProduct() throws JsonProcessingException,Exception{
		MvcResult result = mockMvc.perform(post("/product/api1.0/addProduct")
				.contentType(APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(product)))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println(product);
		
		Product productResponse = mapper.readValue(result.getResponse().getContentAsString(), Product.class);
		System.out.println(productResponse);
		assertEquals(product, productResponse);
	}
	
	

}
