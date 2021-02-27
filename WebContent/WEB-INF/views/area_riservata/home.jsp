<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="user" class="model.User" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/app.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area riservata</title>
</head>
<body>
	<h1>Area riservata</h1>
	<p>
		Benvenuto ${user.email}
		<!--  cambia -->
	</p>
	<p>
		<c:url var="urlLogout" value="/area-riservata/logout" />
		<c:url var="urlCorsi" value="/corsi/list" />
		<c:url var="urlDocenti" value="/docente/list" />
		<c:url var="urlStudenti" value="/studente/list" />

		<c:url var="urlUsers" value="/user/list" />
		<div class="container">

		<div id="home" class="flex-center flex-column">
<a href="${urlCorsi}">Corsi</a> <br /> <a href="${urlDocenti}">Docenti</a>
		<br /> <a href="${urlStudenti}">Studenti</a> <br /> <a
			href="${urlUsers}">Utenti</a>
	</p>
	
 <a href="${urlLogout}">Esci</a>
 
 </div>
	</div>
</body>
</html>