package com.arturkrotiuk.FilmQuiz.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;
import com.arturkrotiuk.FilmQuiz.service.QuizService;
import com.google.gson.GsonBuilder;



@Controller
@RequestMapping(value = "/browse")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping("/")
	public String browseQuizzes(Model model) {
		List <Map<String,String>> list = new ArrayList<>();
		list.addAll(quizService.getQuizzes());
		model.addAttribute("list", list);
		return "browse";
	}
	
	@RequestMapping(value = "/{quizName}", method = RequestMethod.GET)
	public String newQuiz(Model model, 
			@PathVariable("quizName") String quizName) {
		
		Quiz quiz =null;
		try {
			quiz = quizService.getQuiz(quizName);
		} catch (Exception e) {
			// add exception handling
			System.out.println("error");
		}
		Question question = quizService.prepareNewQuestion(quiz);
		model.addAttribute("question", question);
		model.addAttribute("title", quiz.getName());
		return "question";
	}
	
	
	@RequestMapping(value ="/{quizName}/hint", method = RequestMethod.GET, produces= "text/plain;charset=utf-8")
	public @ResponseBody String hint(@RequestParam("key") String key,
			@PathVariable("quizName") String quizName) {
		return quizService.getHint(quizName, key);
	}

	
	@RequestMapping(value ="/{quizName}/result", method = RequestMethod.GET)
	public @ResponseBody String result(@RequestParam("key") String key,
			@PathVariable("quizName") String quizName) {
		return quizService.getResult(quizName,key);
	}
	
	@RequestMapping(value ="/{quizName}/next", method = RequestMethod.GET,  produces= "application/json;charset=utf-8")
	public @ResponseBody String next(@PathVariable("quizName") String quizName) {
		Quiz quiz =null;
		try {
			quiz = quizService.getQuiz(quizName);
		} catch (Exception e) {
			// add exception handling
			System.out.println("error");
		}
		Question question = quizService.prepareNewQuestion(quiz);
		GsonBuilder gson = new GsonBuilder();
		return gson.create().toJson(question);
	}
	


}
