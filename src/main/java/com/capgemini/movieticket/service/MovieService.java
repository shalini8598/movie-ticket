package com.capgemini.movieticket.service;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.dao.MovieDAO;
import com.capgemini.movieticket.exception.InValidIdException;
import com.capgemini.movieticket.exception.InValidNameException;

public class MovieService implements IMovieService {

	MovieDAO daoObject = new MovieDAO();

	public Movie addMovie(Movie object) {
		return daoObject.addMovie(object);
	}

	public Boolean deleteMovie(int movieId) {
		return daoObject.deleteMovie(movieId);
	}

	public void viewMovies() {
		daoObject.viewMovies();
	}
	// validations

	public static boolean isValidMovieId(int movieId) {
		String id = movieId + "";
		boolean validMovieId = id.matches("[3][0-9]{3}");
		if (validMovieId == false) {
			try {
				throw new InValidIdException("Invalid MovieId");
			} catch (InValidIdException e) {
			}
		}
		return validMovieId;

	}

	public static boolean isValidMovieName(String movieName) {
		boolean validMovieName = false;
		validMovieName = movieName.matches("[A-Z][a-z]+");
		if (validMovieName == false) {
			try {
				throw new InValidNameException("InValid MovieName");
			} catch (InValidNameException e) {
			}
		}
		return validMovieName;

	}

	public static boolean isValidMovieDirector(String movieDirector) {
		boolean validMovieDirector = false;
		validMovieDirector = movieDirector.matches("[A-Z][a-z]+");
		if (validMovieDirector == false) {
			try {
				throw new InValidNameException("InValid MovieDirector");
			} catch (InValidNameException e) {

			}
		}

		return validMovieDirector;

	}

	public static boolean isValidMovieGenre(String movieGenre) {
		boolean validMovieGenre = false;
		validMovieGenre = movieGenre.matches("[A-Z][a-z]+");
		if (validMovieGenre == false) {
			try {
				throw new InValidNameException("InValid MovieGenre");
			} catch (InValidNameException e) {

			}
		}

		return validMovieGenre;
	}

	public static boolean isValidMovieLanguage(String movielanguage) {
		boolean validMovieLanguage = false;
		validMovieLanguage = movielanguage.matches("[A-Z][a-z]+");
		if (validMovieLanguage == false) {
			try {
				throw new InValidNameException("InValid MovieLanguage");
			} catch (InValidNameException e) {

			}
		}

		return validMovieLanguage;

	}

	public static boolean existIdCheck(MovieDAO daoobject, int movieId) {
		boolean Idcheck = false;

		daoobject.getListOfMovies().containsKey(movieId);
		return Idcheck;
	}

	public static boolean movieValidation(Movie object, String language, String genre) {
		boolean flag = false;
		if (isValidMovieId(object.getMovieId()) && isValidMovieName(object.getMovieName())
				&& isValidMovieDirector(object.getMovieDirector()) && isValidMovieGenre(genre)
				&& isValidMovieLanguage(language)) {
			flag = true;
		}
		return flag;
	}

}
