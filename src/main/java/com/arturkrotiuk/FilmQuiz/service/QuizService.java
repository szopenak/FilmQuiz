package com.arturkrotiuk.FilmQuiz.service;

import java.util.List;
import java.util.Map;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;

public interface QuizService {

	public Question prepareNewQuestion(Quiz quiz);
	public List<Map<String,String>> getQuizzes();
	public Quiz getQuiz(String quizName);
	public String getHint(String quizName, String key);
	public String getResult(String quizName, String key);

}
