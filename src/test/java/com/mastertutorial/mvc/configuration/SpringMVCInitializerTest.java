package com.mastertutorial.mvc.configuration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.mastertutorial.mvc.controller.IndexController;

public class SpringMVCInitializerTest {

	@Test
	public void testHomePage() throws Exception{
		IndexController indexController = new IndexController();
		MockMvc mockMvc = standaloneSetup(indexController).build();
		mockMvc.perform(get("/"))
		.andExpect(view().name("index"));
		
	}
}
