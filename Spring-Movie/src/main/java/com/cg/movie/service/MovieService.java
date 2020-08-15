package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.Movie;

import com.cg.movie.exception.MovieException;

public interface MovieService {
	

	public  List<Movie>   findAllMovies() throws MovieException;
    public  List<Movie>  findMovieByGenre(String movieGenre) throws MovieException;
    public Movie addMovies(Movie movie);

}
