package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@PropertySource(value = "classpath:application-test0.properties",encoding = "UTF-8")
class DemoSpringConfigApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoadsLessThan1() throws Exception {
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", is("basic")))
				.andExpect(status().isOk());
	}

}
