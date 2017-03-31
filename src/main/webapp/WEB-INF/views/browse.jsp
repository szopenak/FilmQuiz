<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<!--  Bootstrap files -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="/FilmQuiz/resources/js/mainView.js"></script>
		<link rel="stylesheet" href="/FilmQuiz/resources/css/mainStyle.css">
		
		<!--  Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Fredoka+One" rel="stylesheet">
	
		<title>FilmQuiz</title>
	</head>

	<body class = "mainColor3">
		<nav class="navbar mainColor1">
		  <div class="container-fluid">
		    <div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
		        <span class="icon-bar accentColor"></span>
		        <span class="icon-bar accentColor"></span>
		        <span class="icon-bar accentColor"></span> 
		    </button>
		     <a class="navbar-brand" href=" <spring:url value="/" />">FilmQuiz</a>
		    </div>
		    <div class="navbar-collapse collapse" id="navbar">
		    <ul class="nav navbar-nav">
		      <li><a href=" <spring:url value="/browse/" /> ">Browse quizzes</a></li>
		      <li><a href=" <spring:url value="/contact/" /> ">Contact</a></li>
		    </ul>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    </ul>
		    <p class="navbar-text navbar-right" id="greeting"> Hello ${name}! </p>
		  </div>
		  </div>
		</nav>
		
	
		  	<c:forEach items="${list}" var="quiz">
		  	<div class="col-sm-6 col-md-4 col-lg-4 col-xs-12 ">
	
		    <div class="mainColor2 card">
		      <div class="mask mainColor1"></div>

		      <img src=" ${quiz.img}" alt="Couldn't load the image" class="thumbImg">
			  <div class = "maskDesc">
			  	<p>${quiz.description}</p>
		        </div>
		      <div class="tile">
		        <h3>${quiz.name}</h3>
		        <p><a href=" ${quiz.link}" class="btn accentColor " role="button">Start!</a></p>
		        
		      </div>
		    </div>
		    </div>
		    </c:forEach>
	
	
	</body>
</html>