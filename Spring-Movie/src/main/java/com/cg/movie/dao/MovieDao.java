package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

	@Query(" FROM Movie where moviegenre=:genre")
	public List<Movie> findMovieByGenre(@Param("genre") String movieGenre);

}
