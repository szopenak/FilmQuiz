package com.arturkrotiuk.FilmQuiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arturkrotiuk.FilmQuiz.domain.Movie;
import com.arturkrotiuk.FilmQuiz.service.FilmwebService;

import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.search.models.FilmSearchResult;

@Service
public class FilmwebServiceImpl implements FilmwebService{

	@Override
	public List<Movie> getKnownFilms() {
		List <Movie> results = new ArrayList<>();
		FilmwebApi fa = new FilmwebApi();
		List <FilmSearchResult> filmInfoList = fa.findFilm("alien");
		if (!filmInfoList.isEmpty()) {
			FilmSearchResult film = filmInfoList.get(0);
			Movie searchedMovie = new Movie();
			searchedMovie.setTitle(film.getTitle());
			searchedMovie.setYear(film.getYear());
			searchedMovie.setPosterUrl(film.getImageURL());
			results.add(searchedMovie);
		}
		return results;
	}

	@Override
	public List<Movie> getKnownFilms(int number) {
		return null;
	}

}
