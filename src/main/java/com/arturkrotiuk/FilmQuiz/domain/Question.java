package com.arturkrotiuk.FilmQuiz.domain;

import java.sql.Blob;

public class Question {
	private String sentence;
	private String [] responses;
	private int correct;
	private String url;
	private Blob img;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String[] getResponses() {
		return responses;
	}
	public void setResponses(String[] responses) {
		this.responses = responses;
	}
	
	public Question () {
		responses = new String [4];
	}
}
