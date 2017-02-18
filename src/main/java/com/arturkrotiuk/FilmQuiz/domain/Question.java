package com.arturkrotiuk.FilmQuiz.domain;

import org.apache.commons.fileupload.FileItem;

public class Question {
	private String sentence;
	private String [] responses;
	private int correct;
	private FileItem image;
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
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public FileItem getImage() {
		return image;
	}
	public void setImage(FileItem image) {
		this.image = image;
	}
	
	public Question () {
		responses = new String [4];
	}
}
