package com.capgemini.movieticket.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.bean.Show;

public class MovieDAO implements IMovieDAO {

	
	Movie movieObject = new Movie();

	public static Map<Integer, Movie> listOfMovies = new HashMap<Integer,Movie>();

	public Movie addMovie(Movie object) {

		Movie flag = listOfMovies.put(object.getMovieId(), object);

		return object;
	}

	public boolean deleteMovie(int movieId) {
		boolean flag = false;
		Movie delete = listOfMovies.remove(movieId);
		if (delete != null) {
			flag = true;
		}
		return flag;
	}

	public Map<Integer,Movie> viewMovies() {
		return listOfMovies;
		}
	public static void setListOfMovies(Map<Integer,Movie> listOfMovies) {
		MovieDAO.listOfMovies = listOfMovies ;
	}

	}


