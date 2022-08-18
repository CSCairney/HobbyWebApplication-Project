package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Anime;

@Repository
public interface AnimeRepo extends JpaRepository<Anime, Long> {

	// SELECT * FROM Anime WHERE japanese_title = '[japaneseTitle]'
	Anime findAnimeByJapaneseTitle(String japaneseTitle);

	// SELECT * FROM Anime WHERE english_title = '[englishTitle]'
	Anime findAnimeByEnglishTitle(String englishTitle);

	// SELECT * FROM Anime WHERE episodes < [episodes]
	List<Anime> findAnimeByEpisodesLessThan(int episodes);

	// SELECT * FROM Anime WHERE episodes > [episodes]
	List<Anime> findAnimeByEpisodesGreaterThan(int episodes);

	// SELECT * FROM Anime WHERE rating < [rating]
	List<Anime> findAnimeByRatingLessThan(int rating);

	// SELECT * FROM Anime WHERE rating > [rating]
	List<Anime> findAnimeByRatingGreaterThan(int rating);

}
