package com.capgemini.movieticket.bean;

public class Show {

	private String movieGenre;

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		return movieGenre ;
	}
}
