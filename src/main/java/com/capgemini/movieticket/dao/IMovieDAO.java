package com.capgemini.movieticket.dao;

import java.util.Map;

import com.capgemini.movieticket.bean.Movie;

public interface IMovieDAO {
	Movie addMovie(Movie obj);

	boolean deleteMovie(int movieId);

	Map<Integer, Movie> viewMovies();

}
