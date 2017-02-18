package com.arturkrotiuk.FilmQuiz.service;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;

public interface QuizService {
	public String createNewQuiz(String name, String description);
	public Quiz getQuizByName(String name);
	public void addQuestion (Question q, String name);
}
