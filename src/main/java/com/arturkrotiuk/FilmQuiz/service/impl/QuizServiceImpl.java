package com.arturkrotiuk.FilmQuiz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;
import com.arturkrotiuk.FilmQuiz.domain.repository.DatabaseConnector;
import com.arturkrotiuk.FilmQuiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	DatabaseConnector db;

	@Override
	public List<Map<String, String>> getQuizzes() {
		// ad hoc solution
		List <Map<String, String>> list = new ArrayList<>();
		list.add(new HashMap<String,String>() {{
			put("name", "Famous actors");
		    put("description", "Check your knowledge about the world-class actors!");
		    put("img", "http://1.fwcdn.pl/ph/65/97/426597/465777_2.1.jpg");
		    put("link", "actors");
		}});
		list.add(new HashMap<String,String>() {{
			put("name", "Famous actresses");
		    put("description", "Try to guess which actress is shown!");
		    put("img", "http://1.fwcdn.pl/ph/52/02/615202/486054_1.1.jpg");
		    put("link", "actresses");
		}});
		return list;
	}

	@Override
	public Quiz getQuiz(String quizName) {
		// ad hoc solution
		return (quizName.equals("actors") ? new Quiz("Famous actors","actors"):new Quiz("Famous actresses", "actresses"));
	}

	@Override
	public Question prepareNewQuestion(Quiz quiz) {
		// TODO Auto-generated method stub
			return db.getNewQuestion(quiz);
	}

	@Override
	public String getHint(String quizName, String key) {
		// TODO Auto-generated method stub
		return db.getHint(quizName,key);
	}

	@Override
	public String getResult(String quizName, String key) {
		// TODO Auto-generated method stub
		return db.getResult(quizName, key);
	}


	
	
	
	

}
