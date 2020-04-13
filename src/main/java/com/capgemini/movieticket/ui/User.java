package com.capgemini.movieticket.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.bean.Show;
import com.capgemini.movieticket.dao.MovieDAO;
import com.capgemini.movieticket.exception.InValidIdException;
import com.capgemini.movieticket.exception.InValidMovieDirector;
import com.capgemini.movieticket.exception.InValidMovieGenre;
import com.capgemini.movieticket.exception.InValidMovieLanguage;
import com.capgemini.movieticket.exception.InValidNameException;
import com.capgemini.movieticket.service.MovieService;

public class User {
	public static void main(String[] args) {
		
		while (true) {
			try {
				MovieService serviceObject = new MovieService();
                Scanner scan = new Scanner(System.in);
                Random random = new Random();
			

			System.out.println("carryon with the process");
			System.out.println("1.Add Movie");
			System.out.println("2.Delete Movie");
			System.out.println("3.View Movies");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch (choice) {

			case 1:
				
				Movie movieObject = new Movie();
				Show showObject = new Show();
				
				
				 int movieId;
				 String movieName;
				 String movieDirector;
				 int movieLength;
				 LocalDate movieReleaseDate;
				 List<Show> movieGenre = new ArrayList<Show>();
				 List<String> languages = new ArrayList<String>();
				 String Genre = null;
				 String language = null;
				
				try {

				System.out.println("Add Movie");
				movieId = random.nextInt(1000) + 3000;
			    MovieService.isValidMovieId(movieId);
				System.out.println("Enter Movie Name");
			    movieName = scan.next();
			    MovieService.isValidMovieName(movieName);
			    
				System.out.println("Enter Movie Director");
			    movieDirector = scan.next();
			    MovieService.isValidMovieDirector(movieDirector);
				System.out.println("Enter the Duration of the Movie in minutes");
				int MovieLength = scan.nextInt();
				System.out.println("Enter Movie Release Date");
				DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String text = scan.next();
				LocalDate MovieReleaseDate = LocalDate.parse(text, formatdate);
				System.out.println("Enter the Genre of the Movie");
				 Genre = scan.next();
				MovieService.isValidMovieGenre(Genre);
				System.out.println("Enter the Language");
			    language = scan.next();
				MovieService.isValidMovieLanguage(language);
				movieObject.setMovieId(movieId);
				movieObject.setMovieName(movieName);
				movieObject.setMovieDirector(movieDirector);
				movieObject.setMovieLength(MovieLength);
				movieObject.setMovieReleaseDate(MovieReleaseDate);
				showObject.setMovieGenre(Genre);
				movieObject.languages.add(language);
				movieObject.movieGenre.add(showObject);

				boolean existId = MovieService.existIdCheck(movieObject);
				if (existId == true) {

					System.out.println("Movie with Id " + movieObject.getMovieId() + "already exist");
				}
				else {

					
					boolean valid = MovieService.userValidation(movieObject);
					if (valid) {


						Movie add = serviceObject.addMovie(movieObject);
						
						System.out.println("Movie added");
					} 
					else 
					{
						System.out.println(" Could Not Add Movie");
					}
				}
				}
				catch (InValidIdException exception)
				{ 
					System.err.println("Enter a Valid Movie ID");
				}
				catch (InValidNameException exception) {
				System.err.println("Enter a Valid Movie Name");
				}		
				catch(InValidMovieDirector exception)
				{
					System.err.println("Enter a Valid Movie Director");
				}
				catch(InValidMovieGenre exception)
				{
					System.err.println("Enter a Valid Movie Genre");
				}
				catch(InValidMovieLanguage exception)
				{
					System.err.println("Enter a Valid Movie Language");
				}
				

				break;

			case 2:
{
				
				try
				{
				System.out.println("Enter The MovieId");
				int movieId1 = scan.nextInt();
				boolean validId = MovieService.isValidMovieId(movieId1);
				if (validId) {
					boolean flag = serviceObject.deleteMovie(movieId1);
					if (flag == true) {
						System.out.println("Movie With Id " + movieId1 + " Deleted Successfully");

					} 
					else 
					{
						System.out.println("Cannot Delete Movie - MOVIE Is Not Present With Given Id");
					}
				} 
				else 
				{
					System.out.println("Please Enter a Valid Movie Id");
				}
			}
			
			catch (InValidIdException ex)
				{
				System.err.println("Enter a Valid Movie ID");
				}
break;
			}
			case 3:
				if(MovieDAO.listOfMovies.isEmpty())
				{
					System.out.println("Zero Movies Available");
				}
				else
				{
				System.out.println("Available Movies");
				System.out.println();
				Map<Integer,Movie> listOfMovies=serviceObject.viewMovies();
				Set<Integer> set = listOfMovies.keySet();
				Iterator it = set.iterator();
				while (it.hasNext()) {
					Integer key = (Integer) it.next();
					System.out.println("MovieId - " + key + " "+ listOfMovies.get(key));
					
				}
				}
				break;
			case 4:
				System.out.println("You Are Out Of Admin Console");
				System.out.println("Login Again To Add Movies");
				System.exit(0);
			default:
				System.out.println("Please Choose a Valid Choice");
				break;
			}

		//}
		}
		catch(InputMismatchException e)
		{
			System.err.println("Please Enter a Valid Input");
		}
			
	}
}
}
