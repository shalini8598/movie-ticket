package com.capgemini.movieticket.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.capgemini.movieticket.bean.Movie;
import com.capgemini.movieticket.bean.Show;
import com.capgemini.movieticket.dao.MovieDAO;
import com.capgemini.movieticket.service.MovieService;

public class User {
	public static void main(String[] args) {
		MovieService serviceobject = new MovieService();
		//MovieDAO daoObject = new MovieDAO();
		
		
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			
		System.out.println("carryon with the process");
		System.out.println("1.Add Movie");
		System.out.println("2.Delete Movie");
		System.out.println("3.View Movies");
		System.out.println("4.Exit");
		System.out.println("Enter your choice");
		int choice = scan.nextInt();
		switch (choice) {
		
		case 1:Movie beanobject = new Movie();
		Show showobject = new Show();
		MovieDAO daoObject = new MovieDAO();

			System.out.println("Add Movie");
		System.out.println("Enter the Movie Id");
		int movieId= scan.nextInt();
		System.out.println("Enter Movie Name");
		String movieName = scan.next();
		System.out.println("Enter Movie Director");
		String movieDirector = scan.next();
		System.out.println("Enter the Duration of the Movie in minutes");
		int movieLength = scan.nextInt();
		System.out.println("Enter Movie Release Date");
		DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String text = scan.next();
		LocalDate movieReleaseDate = LocalDate.parse(text, formatdate);
		System.out.println("Enter the Genre of the Movie");
		String movieGenre = scan.next();
		System.out.println("Enter the Language");
		String languages = scan.next();
		beanobject.setMovieId(movieId);
		beanobject.setMovieName(movieName);
		beanobject.setMovieDirector(movieDirector);
		beanobject.setMovieLength(movieLength);
		beanobject.setMovieReleaseDate(movieReleaseDate);
		showobject.setMovieGenre(movieGenre);
		beanobject.languages.add(languages);
		  beanobject.movieGenre.add(showobject);
		  
		  boolean existId = MovieService.existIdCheck(daoObject,movieId);

		if(existId == true) {
			System.out.println("Movie with Id " + beanobject.getMovieId() + "Already exist ");
		}
		boolean valid = MovieService.movieValidation(beanobject,languages,movieGenre);
		if(valid)
		{
			Movie add = serviceobject.addMovie(beanobject);
			
			System.out.println("Movie with Id " + add.getMovieId() + add+" added successfuly");
		}
		else
		{
			System.out.println("can not add Movie");
		}
		 
		break;
			
        case 2:
        	System.out.println("Enter the MovieId");
        	int movieId1 = scan.nextInt();
			boolean flag = serviceobject.deleteMovie(movieId1);
			if(flag == true) {
				System.out.println("Movie with Id " + movieId1 + " Deleted Successfully");
			}
			else
			{
				System.out.println("Movie not Deleted");
			}
			break;
        case 3:
        	
        	System.out.println("Available Movies");
        	serviceobject.viewMovies();
            break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	}
}


