package com.arturkrotiuk.FilmQuiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.arturkrotiuk.FilmQuiz.domain.Movie;
import com.arturkrotiuk.FilmQuiz.domain.MovieDAO;

@Controller
public class HomeController {
	@Autowired
	private MovieDAO movieDAO;
	
	@RequestMapping("/")
	public String welcome(Model model) {
	model.addAttribute("name", "stranger");
	return "home";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
	model.addAttribute("name", "stranger");
	return "contact";
	}
}
