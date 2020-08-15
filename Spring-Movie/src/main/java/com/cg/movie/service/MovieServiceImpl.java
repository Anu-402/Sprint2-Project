package com.cg.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.MovieDao;
import com.cg.movie.entity.Movie;
import com.cg.movie.exception.MovieException;


@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;
	
	
	@Override
	public List<Movie> findAllMovies() throws MovieException {

		List<Movie> list = movieDao.findAll();
		
		return list;
	}

	@Override
	public List<Movie> findMovieByGenre(String movieGenre) throws MovieException {

		if( movieDao.findMovieByGenre(movieGenre)==null)
		{
			throw new MovieException(" No movies with that genre ");
		}
		
		return movieDao.findMovieByGenre(movieGenre);
	
	}

	@Override
	public Movie addMovies(Movie movies) {
		 Movie  m = movieDao.saveAndFlush(movies);
	     return m;
	}

}
