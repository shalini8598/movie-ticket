package com.capgemini.movieticket.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieDirector;
	private int movieLength;
	private LocalDate movieReleaseDate;
	public List<Show> movieGenre = new ArrayList<Show>();
	public List<String> languages = new ArrayList<String>();

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public List<Show> getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(List<Show> movieGenre) {
		this.movieGenre = movieGenre;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Movie(int movieId, String movieName, String movieDirector, int movieLength, LocalDate movieReleaseDate,
			List<Show> movieGenre, List<String> languages) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.movieReleaseDate = movieReleaseDate;
		this.movieGenre = movieGenre;
		this.languages = languages;
	}

	public Movie() {
		super();
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", movieLength=" + movieLength + ", movieReleaseDate=" + movieReleaseDate + ", movieGenre="
				+ movieGenre + ", languages=" + languages + "]";
	}

	
}
