package com.qa.main.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Anime;
import com.qa.main.repos.AnimeRepo;

@SpringBootTest
public class AnimeServiceUnitTest {

	@Autowired
	private AnimeService service;
	
	@MockBean
	private AnimeRepo repo;
	
	@Test
	public void testCreate() {
		
		//Create objects of Anime
		Anime entry = new Anime("e", "j", 1, 5, 5, true);
		//result object including "id" after mock processed through the service (JSON)
		Anime result = new Anime(2L, "e", "j", 1, 5, 5, true);
	
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		
		assertEquals(result, service.create(entry));
	}
	
	@Test
	public void testGetAll() {
		
		//Create objects of Anime
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
			
		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
//	@Test
//	public void getById() {
//		Optional<Anime> result = Optional.of(new Anime(2L, "e", "j", 1, 5, 5, true));
//		
//		Mockito.when(repo.findById(2L)).thenReturn(result);
//		
//		assertEquals(result, service.getByID(2L));
//	}
	
	
	@Test
	public void getEnglishTitleTest() {
		Anime result = new Anime("e", "j", 1, 5, 5, true);
		
		Mockito.when(repo.findAnimeByEnglishTitle("e")).thenReturn(result);
		
		assertEquals(result, service.getByEnglishTitle("e"));
	}
	
	@Test
	public void getJapaneseTitleTest() {
		Anime result = new Anime("e", "j", 1, 5, 5, true);
		
		Mockito.when(repo.findAnimeByJapaneseTitle("j")).thenReturn(result);
		
		assertEquals(result, service.getByJapaneseTitle("j"));
	}
	
	@Test
	public void getByEpisodesLessThan() {
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
		
		Mockito.when(repo.findAnimeByEpisodesLessThan(6)).thenReturn(result);
		
		assertEquals(result, service.getByEpisodesLessThan(6));
	}
	
	@Test
	public void getByEpisodesGreaterThan() {
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
		
		Mockito.when(repo.findAnimeByEpisodesGreaterThan(4)).thenReturn(result);
		
		assertEquals(result, service.getByEpisodesGreaterThan(4));
	}
	
	@Test
	public void getByRatingLessThan() {
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
		
		Mockito.when(repo.findAnimeByRatingLessThan(6)).thenReturn(result);
		
		assertEquals(result, service.getByRatingLessThan(6));
	}
	
	@Test
	public void getByRatingGreaterThan() {
		List<Anime> result = new ArrayList<>();
		result.add(new Anime("e", "j", 1, 5, 5, true));
		
		Mockito.when(repo.findAnimeByRatingGreaterThan(4)).thenReturn(result);
		
		assertEquals(result, service.getByRatingGreaterThan(4));
	}
	
//	@Test
//	public void testUpdate() {
//
//		Anime entry = new Anime("e", "j", 1, 5, 5, true);
//		Anime result = new Anime("e", "j", 1, 5, 5, true);
//		
//		Mockito.when(repo.findById(2L)).thenReturn(entry);
//		
//		assertEquals(result, service.update(2L, entry));
//	}
}
