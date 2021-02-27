<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	
	<c:url var="urlStudente" value="/studente/list" />
	<c:url var="urlDocente" value="/docente/list" />
	<c:url var="urlCorsi" value="/corsi/list" />
	    <div class="container">
	
	<div id="home" class="flex-center flex-column">
		
			<a class="btn" href="${urlStudente}">Studenti</a>
			<br>
			<a class="btn" href="${urlDocente}">Docenti</a>
			<br>
			<a class="btn" href="${urlCorsi}">Corsi</a>
			<br>

		
	</div>

	</div>






</body>
</html>