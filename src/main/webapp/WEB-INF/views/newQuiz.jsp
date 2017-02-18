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

	<title>Witaj</title>
</head>

<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span> 
	    </button>
	     <a class="navbar-brand" href=" <spring:url value="/" />">FilmQuiz</a>
	    </div>
	    <div class="navbar-collapse collapse" id="navbar">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Quiz</a></li>
	      <li><a href=" <spring:url value="/quiz/add" />">Add quiz</a></li>
	      <li><a href="#">Contact</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	    <p class="navbar-text navbar-right" id="greeting"> Hello, ${name}! </p>
	  </div>
	  </div>
	</nav>
	


		<section class="container">
			<form:form modelAttribute="newQuiz" class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<fieldset>
					<legend>Stworz wlasny quiz!</legend>
						<div class="form-group">
							<label class="control-label col-lg-2 col-lg-2" for="title">
							Nazwa:
							</label>
								<div class="col-lg-10">
								<form:input id="title" path="title" type="text" class="form:input-large"/>
								<form:errors path="title" cssClass="text-danger"/>
								</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-lg-2 col-lg-2" for="responses[0]">
							Opis:
							</label>
									<div class="col-lg-10">
									<form:input id="description" path="description" type="text" class="form:input-large"/>
									<form:errors path="description" cssClass="text-danger"/>
									</div>
						</div>
						
						
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>


</body>
</html>