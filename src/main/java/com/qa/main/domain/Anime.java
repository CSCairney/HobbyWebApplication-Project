package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anime {

	//Columns
	//Id tag tells spring this is the primary key
	//Generate value tells the spring this is auto incremented.
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@Column(name = "English Title") allows you to force a name change 
	
	@Column(unique = true, nullable = false)
	private String englishTitle; //Creates a column called english_title with the datatype VARCHAR(255)
	
	@Column(unique = true, nullable = false)
	private String japaneseTitle;
	
	@Column(nullable = false)
	private int seasons;
	
	@Column(nullable = false)
	private int episodes;
	
	@Column(nullable = false)
	private int rating;
	
	@Column(nullable = false)
	private boolean complete;
	
	//Constructors
	
	//Default Constructor (for spring)
	public Anime() {

	}
	
	//For Creating (without ID)
	public Anime(String englishTitle, String japaneseTitle, int seasons, int episodes, int rating, boolean complete) {
		super();
		this.englishTitle = englishTitle;
		this.japaneseTitle = japaneseTitle;
		this.seasons = seasons;
		this.episodes = episodes;
		this.rating = rating;
		this.complete = complete;
	}

	//For Reading
	public Anime(long id, String englishTitle, String japaneseTitle, int seasons, int episodes, int rating,
			boolean complete) {
		super();
		this.id = id;
		this.englishTitle = englishTitle;
		this.japaneseTitle = japaneseTitle;
		this.seasons = seasons;
		this.episodes = episodes;
		this.rating = rating;
		this.complete = complete;
	}

	

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnglishTitle() {
		return englishTitle;
	}

	public void setEnglishTitle(String englishTitle) {
		this.englishTitle = englishTitle;
	}

	public String getJapaneseTitle() {
		return japaneseTitle;
	}

	public void setJapaneseTitle(String japaneseTitle) {
		this.japaneseTitle = japaneseTitle;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(complete, englishTitle, episodes, id, japaneseTitle, rating, seasons);
	}

	//Override Methods
	//Used for Testing
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anime other = (Anime) obj;
		return complete == other.complete && Objects.equals(englishTitle, other.englishTitle)
				&& episodes == other.episodes && id == other.id && Objects.equals(japaneseTitle, other.japaneseTitle)
				&& rating == other.rating && seasons == other.seasons;
	}
	
		
	
	
}

