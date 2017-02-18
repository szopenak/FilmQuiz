package com.arturkrotiuk.FilmQuiz.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz {
	private List <Question> questions;
	private String author;
	private Date createdOn;
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Quiz() {
		questions = new ArrayList<Question>();
		questions.add(new Question());
		createdOn = new Date();
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	
}
