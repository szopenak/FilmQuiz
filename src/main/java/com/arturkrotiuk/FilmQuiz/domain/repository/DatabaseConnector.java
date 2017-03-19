package com.arturkrotiuk.FilmQuiz.domain.repository;

import java.sql.Connection;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;

public interface DatabaseConnector {
	String getRecord(String url);
	Question getNewQuestion(Quiz quiz);
	String getHint(String quizName, String key);
	String getResult(String quizName, String key);
	
}
