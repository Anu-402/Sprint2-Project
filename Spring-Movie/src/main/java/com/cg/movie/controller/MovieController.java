package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.Movie;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.MovieService;

@RestController
@CrossOrigin("*")
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("movie")
	public ResponseEntity<List<Movie>> findAllMovies() throws MovieException {

		List<Movie> list = movieService.findAllMovies();
		ResponseEntity<List<Movie>> rt = new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
		return rt;

	}

	@GetMapping("movie/{genre}")
	public ResponseEntity<List<Movie>> findMovieByGenre(@PathVariable("genre") String movieGenre) throws MovieException {

		List<Movie> movies = movieService.findMovieByGenre(movieGenre);
		ResponseEntity<List<Movie>> re = new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	
		return re;

	}
	
	
	
	@PostMapping("movies")
	public ResponseEntity<Movie>  Movies(@RequestBody Movie movies)
	{
		   movies = movieService.addMovies(movies);
		   ResponseEntity<Movie> rt= new ResponseEntity<Movie>(movies,HttpStatus.OK);
		   return rt;
	}

}
