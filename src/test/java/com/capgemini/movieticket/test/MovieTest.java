package com.capgemini.movieticket.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.bean.Show;
import com.capgemini.movieticket.dao.MovieDAO;

public class MovieTest {
	MovieDAO dao = null;
	Show show = new Show();
	List<Show> movieGenre = new ArrayList<Show>();
	List<String> languages = new ArrayList<String>();

	Movie movie = new Movie(3456, "Kushi", "Surya", 160, LocalDate.of(2001, 04, 27), movieGenre, languages);

	@Before
	public void addMovie() {
		dao = new MovieDAO();
	}

	@Test
	public void testaddMovie() {
		Movie movie1 = dao.addMovie(movie);
		assertEquals(movie1.getMovieId(), movie.getMovieId());
	}

	@Test
	public void testDeleteMovie() {
		boolean movie2 = dao.deleteMovie(3456);
		assertEquals(movie.getMovieId(), 3456);

	}
}
