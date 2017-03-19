package com.arturkrotiuk.FilmQuiz.domain;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz {
	private Blob img;
	private String name;
	private String author;
	private String url;
	public Quiz(String name, String url) {
		this.name = name;
		this.setUrl(url);
	}
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
