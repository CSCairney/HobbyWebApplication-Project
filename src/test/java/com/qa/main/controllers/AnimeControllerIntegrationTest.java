package com.qa.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Anime;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") //allows us to switch to the H2 database
public class AnimeControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; // USed for converting objects to JSON
	
	@Test
	public void createTest() throws Exception {
		//Create an Object for posting
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		//Create an Object to check result
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/Anime/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception {
		
		//Create a list to cehck the output of readAll
		List<Anime> result = new ArrayList<>();
		//Add the single entry to the list
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
		
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readByIdTest() throws Exception {
		//Create an anime to check the output of readById
				Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
											
				//converts the list to a JSON (As API responds in JSON)
				String resultAsJSON = mapper.writeValueAsString(result);
				mvc.perform(get("/Anime/getByID/1")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(content().json(resultAsJSON));
		
	}
	
	@Test
	public void getByJapaneseTitle() throws Exception {
		//Create an anime to check the output of readById
				Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
											
				//converts the list to a JSON (As API responds in JSON)
				String resultAsJSON = mapper.writeValueAsString(result);
				mvc.perform(get("/Anime/getByJapaneseTitle/japanese")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(content().json(resultAsJSON));
		
	}
	
//	@Test
//	public void getByEnglishTitle() throws Exception {
//		//Create an anime to check the output of readById
//				Anime result = new Anime(1L, "e", "japanese", 1, 10, 5, true);
//											
//				//converts the list to a JSON (As API responds in JSON)
//				String resultAsJSON = mapper.writeValueAsString(result);
//				mvc.perform(get("/Anime/getByEnglishTitle/e")
//						.contentType(MediaType.APPLICATION_JSON))
//						.andExpect(content().json(resultAsJSON));
//		
//	}
	
	@Test
	public void getByEpisodesLessThan() throws Exception {
		//Create an anime to check the output of readById
		List<Anime> result = new ArrayList<>();
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
									
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getByEpisodesLessThan/20")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByEpisodesGreaterThan() throws Exception {
		//Create an anime to check the output of readById
		List<Anime> result = new ArrayList<>();
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
									
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getByEpisodesGreaterThan/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		//Create an Object for posting
				Anime result = new Anime(1L, "english", "japanese", 1, 10, 5, true);
				String resultAsJSON = mapper.writeValueAsString(result);
				
				mvc.perform(put("/Anime/update/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(resultAsJSON))
					.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByRatingLessThan() throws Exception {
		//Create an anime to check the output of readById
		List<Anime> result = new ArrayList<>();
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
									
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getByRatingLessThan/10")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByRatingGreaterThan() throws Exception {
		//Create an anime to check the output of readById
		List<Anime> result = new ArrayList<>();
		result.add(new Anime(1L, "english", "japanese", 1, 10, 5, true));
									
		//converts the list to a JSON (As API responds in JSON)
		String resultAsJSON = mapper.writeValueAsString(result);
		mvc.perform(get("/Anime/getByRatingGreaterThan/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/Anime/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		
	}
	
	@Test
	public void ExceptionTest() throws Exception {
		mvc.perform(get("/Anime/getByID/90")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		
	}

}
