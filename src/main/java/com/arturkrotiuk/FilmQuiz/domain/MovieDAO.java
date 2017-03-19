package com.arturkrotiuk.FilmQuiz.domain;

import java.util.List;

public interface MovieDAO {

	//Create
		public void save(Movie movie);
		//Read
		public Movie getById(int id);
//		//Update
//		public void update(Movie movie);
//		//Delete
//		public void deleteById(int id);
		//Get All
		public List<Movie> getAll();
}
