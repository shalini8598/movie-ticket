package com.capgemini.movieticket.dao;

import com.capgemini.movieticket.bean.Movie;

public interface IMovieDAO {
	Movie addMovie(Movie obj);
	boolean deleteMovie(int movieId);
	void viewMovies();
	
}
