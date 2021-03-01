package com.rakuten.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	int id;
	@Column(name = "name")
	String movieName;
	@Column(name = "movie_desc")
	String movieDesc;
	@Column(name = "numSongs")
	int  numSongs;
	@Column(name = "numFight")
	int numFight;
	@Column(name = "genre")
	String genre;
	
	public Movie(String name,String moviedesc, int numSongs,int numFight, String genre)
	{
		super();
		this.movieName=name;
		this.genre=genre;
		this.movieDesc=moviedesc;
		this.numFight=numFight;
		this.numSongs=numSongs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public int getNumSongs() {
		return numSongs;
	}

	public void setNumSongs(int numSongs) {
		this.numSongs = numSongs;
	}

	public int getNumFight() {
		return numFight;
	}

	public void setNumFight(int numFight) {
		this.numFight = numFight;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
