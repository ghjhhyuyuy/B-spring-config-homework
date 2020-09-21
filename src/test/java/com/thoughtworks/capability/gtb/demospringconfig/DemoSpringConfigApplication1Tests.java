package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@PropertySource(value = "classpath:application-test.properties",encoding = "UTF-8")
class DemoSpringConfigApplication1Tests {
	@Autowired
	private MockMvc mockMvc;

	@Value("${levelNumber}")
	private int levelNumber;
	@Test
	void contextLoadsMoreThan1() throws Exception {
		System.out.println(levelNumber);
		mockMvc.perform(get("/level"))
				.andExpect(jsonPath("$", is("advanced")))
				.andExpect(status().isOk());
	}

}
