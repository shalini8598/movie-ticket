package com.capgemini.movieticket.service;

import java.util.Map;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.dao.IMovieDAO;
import com.capgemini.movieticket.dao.MovieDAO;
import com.capgemini.movieticket.exception.InValidIdException;
import com.capgemini.movieticket.exception.InValidMovieDirector;
import com.capgemini.movieticket.exception.InValidMovieGenre;
import com.capgemini.movieticket.exception.InValidMovieLanguage;
import com.capgemini.movieticket.exception.InValidNameException;

public class MovieService implements IMovieService {

	IMovieDAO MovieDAOobject = new MovieDAO();

	public Movie addMovie(Movie movieObject) {
		return MovieDAOobject.addMovie(movieObject);
	}

	public boolean deleteMovie(int movieId) {
		return MovieDAOobject.deleteMovie(movieId);
	}

	public Map<Integer, Movie> viewMovies() {
		return MovieDAOobject.viewMovies();
	}
	// validations

	public static boolean isValidMovieId(int movieId) {
		boolean flag = false;
		String id = movieId + "";
		flag = id.matches("[3][0-9]{3}");
		if (flag == false) {
			throw new InValidIdException();
		}

		return flag;
	}

	public static boolean isValidMovieName(String movieName) {
		boolean flag = false;
		flag = movieName.matches("[A-Z][a-z]+");

		if (flag == false) {

			throw new InValidNameException();

		}
		return flag;
	}

	public static boolean isValidMovieDirector(String movieDirector) {
		boolean flag = false;
		flag = movieDirector.matches("[A-Z][a-z]+");
		if (flag == false) {
			throw new InValidMovieDirector();

		}
		return flag;
	}

	public static boolean isValidMovieGenre(String movieGenre) {
		boolean flag = false;
		flag = movieGenre.matches("[A-Z][a-z]+");
		if (flag == false) {
			throw new InValidMovieGenre();

		}
		return flag;
	}

	public static boolean isValidMovieLanguage(String movieLanguage) {
		boolean flag = false;
		flag = movieLanguage.matches("[A-Z][a-z]+");
		if (flag == false) {
			throw new InValidMovieLanguage();

		}
		return flag;
	}

	public static boolean existIdCheck(Movie movieObject) {
		boolean flag = false;

		flag = MovieDAO.listOfMovies.containsKey(movieObject.getMovieId());

		return flag;

	}

	public static boolean userValidation(Movie object) {
		boolean flag = false;
		if (isValidMovieId(object.getMovieId()) && isValidMovieName(object.getMovieName())
				&& isValidMovieDirector(object.getMovieDirector())) {
			flag = true;
		}
		return flag;
	}

}
