package com.qa.main.controllers;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.Services.AnimeService;
import com.qa.main.domain.Anime;

@WebMvcTest
public class AnimeControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private AnimeService service;
	
	@Test
	void createTest() throws Exception {
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		//Create an Object to check result
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.create(entry)).thenReturn(result);
		
		mvc.perform(post("/Anime/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	void updateTest() throws Exception {
		//Create an Object to check result
		Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		Mockito.when(service.update(1L, result)).thenReturn(result);
		
		mvc.perform(put("/Anime/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(resultAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
	
	
	@Test
	void getAllTest() throws Exception {
		//Create a list to check the output of readAll
				List<Anime> result = new ArrayList<>();
				//Add the single entry to the list
				result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
				
				Mockito.when(service.getAll()).thenReturn(result);
				
				//converts the list to a JSON (As api responds in JSON)
				String resultAsJSON = mapper.writeValueAsString(result);
				mvc.perform(get("/Anime/getAll")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(content().json(resultAsJSON));
	}

	
}
