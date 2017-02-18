package com.arturkrotiuk.FilmQuiz.service;

import java.util.List;

import com.arturkrotiuk.FilmQuiz.domain.Movie;

public interface FilmwebService {
	List <Movie> getKnownFilms();
	List <Movie> getKnownFilms(int number);
}
