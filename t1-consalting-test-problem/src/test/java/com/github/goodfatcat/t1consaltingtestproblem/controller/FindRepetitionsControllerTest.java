package com.github.goodfatcat.t1consaltingtestproblem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.goodfatcat.t1consaltingtestproblem.dto.LineRequest;

@SpringBootTest
@AutoConfigureMockMvc
class FindRepetitionsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldReturnCorrectly() throws JsonProcessingException, Exception {
		Map<String, Integer> expectedMap = new LinkedHashMap<>();
		expectedMap.put("a", 5);
		expectedMap.put("c", 4);
		expectedMap.put("b", 1);

		String expectedJson = objectMapper.writeValueAsString(expectedMap);

		mockMvc.perform(get("/api/findRepetitionsInLine")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper
						.writeValueAsString(new LineRequest("aaaaabcccc"))))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}
}
