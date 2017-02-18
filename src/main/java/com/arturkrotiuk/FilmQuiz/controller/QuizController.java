package com.arturkrotiuk.FilmQuiz.controller;

import java.io.File;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;
import com.arturkrotiuk.FilmQuiz.service.QuizService;


@Controller
@RequestMapping(value = "/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewQuizForm(Model model, @ModelAttribute("newQuiz") Quiz newQuiz) {

		return "newQuiz";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewQuizForm(Model model, @ModelAttribute("newQuiz") Quiz newQuiz) {
		System.out.println(newQuiz.getTitle()+ newQuiz.getDescription());
		// check validator and binding
		quizService.createNewQuiz(newQuiz.getTitle(), newQuiz.getDescription());
		return "redirect:/quiz/add/"+newQuiz.getTitle();
	}
	
	@RequestMapping(value = "/add/{quizId}", method = RequestMethod.GET)
	public String addQuestions(Model model, @PathVariable("quizId") String quizId, @ModelAttribute("newQuestion") Question newQuestion) { 
		// check if quiz might be changed - if it's done or not / is user authenticated or able to do that

		return "addQuestion";
	}
	
	@RequestMapping(value = "/add/{quizId}", method = RequestMethod.POST)
	public String processAddQuestions(Model model, @PathVariable("quizId") String quizId, @ModelAttribute("newQuestion") Question newQuestion) { 
		// check if quiz might be changed - if it's done or not / is user authenticated or able to do that
		// handle filling the array... 
		for (String x : newQuestion.getResponses()) {
			System.out.println(x);
		}
		return "redirect:/quiz/add/"+quizId;
	}
	
	

//	@InitBinder
//	public void initialiseBinder(WebDataBinder binder) {
//		binder.setValidator(productValidator);
//		//binder.setDisallowedFields("unitsInOrder", "discontinued");
//		binder.setAllowedFields("productId", "name", "unitPrice", "description","manufacturer", 
//				"category", "unitsInStock", "productImage","language");
//		}

}
