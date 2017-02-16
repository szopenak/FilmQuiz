package com.arturkrotiuk.FilmQuiz.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arturkrotiuk.FilmQuiz.domain.Movie;
import com.arturkrotiuk.FilmQuiz.service.filmwebService;

import info.talacha.filmweb.api.FilmwebApi;

@Service
public class filmwebServiceImpl implements filmwebService{

	@Override
	public List<Movie> getKnownFilms() {
		FilmwebApi fa = new FilmwebApi();
		return null;
	}

	@Override
	public List<Movie> getKnownFilms(int number) {
		return null;
	}

}
