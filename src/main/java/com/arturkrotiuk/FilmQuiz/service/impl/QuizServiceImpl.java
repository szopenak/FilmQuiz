package com.arturkrotiuk.FilmQuiz.service.impl;

import org.springframework.stereotype.Service;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;
import com.arturkrotiuk.FilmQuiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Override
	public String createNewQuiz(String name, String description) {
		// TODO Auto-generated method stub
		return "id";
	}

	@Override
	public Quiz getQuizByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addQuestion(Question q, String name) {
		// TODO Auto-generated method stub
		
	}

}
