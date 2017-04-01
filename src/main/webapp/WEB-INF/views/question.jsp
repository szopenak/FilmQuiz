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
		<link href='http://fonts.googleapis.com/css?family=Atma&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	
		<title>FilmQuiz</title>
	</head>

	<body class="mainColor3">
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
		
		
		<div>
		
		<div class=" image-wrapper mainColor2">
			<h1 id="title">${title} <hr></h1>
	      	<img src="${question.url}" alt="Actor image" id="question-image">
	      	<div class = "question">
		      	<p id="question">${question.sentence} <hr> </p>
		      	
		    	<button id="choice1" class="btn btn-default">${question.responses[0]}</button>
		    	<button id="choice2" class="btn btn-default">${question.responses[1]}</button>
		    	<button id="choice3" class="btn btn-default">${question.responses[2]}</button>
		    	<button id="choice4" class="btn btn-default">${question.responses[3]}</button>
		    	
	    	</div>
	    	<div class="funtion-buttons">
		    	<button class="btn btn-default" id="hint" data-toggle="modal" data-target="#hintModal" >
		      	Get hint!<span class="glyphicon glyphicon-question-sign"></span> 
		      	</button>
		      	<button class="btn accentColor" id="next">
		      	Next!<span class="glyphicon glyphicon-chevron-right"></span>
		      	</button>
	      	</div>
	  	</div>
	  	
	  	</div>
	  	
	
	
		<!-- HintModal -->
		<div id="hintModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content  mainColor2">
		      <div class="modal-header">
		        <h4 class="modal-title">Hint!</h4>
		      </div>
		      <div class="modal-body">
		        <p id="hint-message">No hint available</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn accentColor" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		
		  </div>
		</div>
		
	</body>
</html>