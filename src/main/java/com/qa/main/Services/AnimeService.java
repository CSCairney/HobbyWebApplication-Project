package com.qa.main.Services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Anime;
import com.qa.main.exception.AnimeNotFoundException;
import com.qa.main.repos.AnimeRepo;

@Service
public class AnimeService {

	private AnimeRepo repo;

	public AnimeService(AnimeRepo repo) {
		this.repo = repo;
	}

	// POST REQUESTS - CREATE
	public Anime create(Anime entry) {
		return repo.saveAndFlush(entry);
	}

	// GET REQUESTS - READ
	public List<Anime> getAll() {
		return repo.findAll();
	}

	// GET REQUEST - Specific get request for one ID
	public Anime getByID(long id) {
		return repo.findById(id).orElseThrow(AnimeNotFoundException::new);

	}

	// GET REQUEST - Specific get request for japanese_title
	public Anime getByJapaneseTitle(String japaneseTitle) {
		return repo.findAnimeByJapaneseTitle(japaneseTitle);
	}

	// GET REQUEST - Specific get request for english_title
	public Anime getByEnglishTitle(String englishTitle) {
		return repo.findAnimeByEnglishTitle(englishTitle);
	}

	// GET REQUEST - Specific get request for episodes < [episodes]
	public List<Anime> getByEpisodesLessThan(int episodes) {
		return repo.findAnimeByEpisodesLessThan(episodes);
	}

	// GET REQUEST - Specific get request for episodes > [episodes]
	public List<Anime> getByEpisodesGreaterThan(int episodes) {
		return repo.findAnimeByEpisodesGreaterThan(episodes);
	}
	
	// GET REQUEST - Specific get request for rating < [rating]
	public List<Anime> getByRatingLessThan(int rating){
		return repo.findAnimeByRatingLessThan(rating);
	}
	
	// GET REQUEST - Specific get request for rating > [rating]
		public List<Anime> getByRatingGreaterThan(int rating){
			return repo.findAnimeByRatingGreaterThan(rating);
		}

	// PUT REQUESTS - UPDATE
	public Anime update(long id, Anime anime) {
		// get existing entry
		Anime existing = repo.findById(id).get();
		// update existing entry
		existing.setEnglishTitle(anime.getEnglishTitle());
		existing.setJapaneseTitle(anime.getJapaneseTitle());
		existing.setEpisodes(anime.getEpisodes());
		existing.setSeasons(anime.getSeasons());
		existing.setRating(anime.getRating());
		existing.setComplete(anime.isComplete());

		// Save the updated entry back into the DB (ID is the Same)
		return repo.saveAndFlush(existing);
	}

	// DELETE REQUESTS - DELETE
	public Boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);

	}

}
