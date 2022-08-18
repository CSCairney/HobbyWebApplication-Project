package com.qa.main.controllers;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.Services.AnimeService;
import com.qa.main.domain.Anime;

@RestController
@CrossOrigin
@RequestMapping("/Anime")
public class AnimeController {

	private AnimeService service;

	public AnimeController(AnimeService service) {
		this.service = service;
	}

	// POST REQUESTS - CREATE
	@PostMapping("/create")
	public ResponseEntity<Anime> create(@RequestBody Anime entry) {
		return new ResponseEntity<Anime>(service.create(entry), HttpStatus.CREATED);
	}

	// GET REQUESTS - READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Anime>> getAll() {
		return new ResponseEntity<List<Anime>>(service.getAll(), HttpStatus.CREATED);
	}

	// GET REQUEST - Specific get request for one ID
	@GetMapping("/getByID/{id}")
	public ResponseEntity<Anime> getByID(@PathVariable("id") long id) { // only an int here as we are using an array
																		// change to long on actual DB
		return new ResponseEntity<Anime>(service.getByID(id), HttpStatus.CREATED);
	}

	// GET REQUEST - Specific get Request for Japanese Title
	@GetMapping("/getByJapaneseTitle/{japaneseTitle}")
	public ResponseEntity<Anime> getByJapaneseTitle(@PathVariable String japaneseTitle) {
		return new ResponseEntity<Anime>(service.getByJapaneseTitle(japaneseTitle), HttpStatus.CREATED);
	}

	// GET REQUEST - Specific get Request for English Title
	@GetMapping("/getByEnglishTitle/{englishTitle}")
	public ResponseEntity<Anime> getByEnglishTitle(@PathVariable String englishTitle) {
		return new ResponseEntity<Anime>(service.getByEnglishTitle(englishTitle), HttpStatus.CREATED);
	}

	// GET REQUEST - Specific get Request for Episodes < [episodes]
	@GetMapping("/getByEpisodesLessThan/{episodes}")
	public ResponseEntity<List<Anime>> getByEpisodesLessThan(@PathVariable("episodes") int episodes) {
		return new ResponseEntity<List<Anime>>(service.getByEpisodesLessThan(episodes), HttpStatus.CREATED);
	}

	// GET REQUEST - Specific get Request for Episodes > [episodes]
	@GetMapping("/getByEpisodesGreaterThan/{episodes}")
	public ResponseEntity<List<Anime>> getByEpisodesGreaterThan(@PathVariable("episodes") int episodes) {
		return new ResponseEntity<List<Anime>>(service.getByEpisodesGreaterThan(episodes), HttpStatus.CREATED);
	}
	
	// GET REQUEST - Specific get Request for Rating < [rating]
	@GetMapping("/getByRatingLessThan/{rating}")
	public ResponseEntity<List<Anime>> getByRatingLessThan(@PathVariable("rating") int rating){
		return new ResponseEntity<List<Anime>>(service.getByRatingLessThan(rating), HttpStatus.CREATED);
	}
	
	// GET REQUEST - Specific get Request for Rating > [rating]
	@GetMapping("/getByRatingGreaterThan/{rating}")
		public ResponseEntity<List<Anime>> getByRatingGreaterThan(@PathVariable("rating") int rating){
			return new ResponseEntity<List<Anime>>(service.getByRatingGreaterThan(rating), HttpStatus.CREATED);
		}

	// PUT REQUESTS - UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Anime> update(@PathVariable("id") long id, @RequestBody Anime anime) {
		return new ResponseEntity<Anime>(service.update(id, anime), HttpStatus.CREATED);
	}

	// DELETE REQUESTS - DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);

	}

}
