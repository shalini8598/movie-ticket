package com.capgemini.movieticket.service;

import com.capgemini.movieticket.bean.Movie;

public interface IMovieService {
	Movie addMovie(Movie object);
	Boolean deleteMovie(int movieId);
	public void viewMovies();

}
