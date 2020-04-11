package com.capgemini.movieticket.service;

import java.util.Map;

import com.capgemini.movieticket.bean.Movie;

public interface IMovieService {
	Movie addMovie(Movie object);
	boolean deleteMovie(int movieId);
	 Map<Integer,Movie> viewMovies();

}
