package com.cg.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "movie_tbl")
public class Movie {

	@Id
	@GeneratedValue(generator = "mygen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "mygen", sequenceName = "moviesqlplus_seq", allocationSize = 1)
	@Column(name = "movieid")
	private Integer movieId;
	@Column(name = "moviename", length = 15)
	private String movieName;
	@Column(name = "movierating")
	private Integer movieRating;
	@Column(name = "moviegenre", length = 15)
	private String movieGenre;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	
}
