package com.arturkrotiuk.FilmQuiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arturkrotiuk.FilmQuiz.domain.Movie;
import com.arturkrotiuk.FilmQuiz.service.FilmwebService;

import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.search.models.FilmSearchResult;


@Controller
public class HomeController {
	

	
	@RequestMapping("/")
	public String welcome(Model model) {
	model.addAttribute("name", "stranger");
	
	return "home";
	}
}
