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
	
	Map<Integer,Movie> listOfMovies = new HashMap<Integer,Movie>();
Movie movieObject=new Movie();

	public Map<Integer, Movie> getListOfMovies() {
	return listOfMovies;
}

public void setListOfMovies(Map<Integer, Movie> listOfMovies) {
	this.listOfMovies = listOfMovies;
}

	public Movie addMovie(Movie obj) {
		Movie ticket = null;

		listOfMovies.put(obj.getMovieId(), obj);
	  
		 ticket =obj;
		return ticket;
	}

	public boolean deleteMovie(int movieId) {
		boolean flag = false;
		Movie delete = listOfMovies.remove( movieId);
		if(delete!=null) {
			flag = true;
		}
   		return flag;
	}

	
	public void viewMovies() {
Collection<Movie>collection = listOfMovies.values();
List<Movie> list = new ArrayList<Movie>(collection);

for(Movie movie:list) {
	System.out.println(movie+" ");
		}
		
		
		
		
	}
	

}
