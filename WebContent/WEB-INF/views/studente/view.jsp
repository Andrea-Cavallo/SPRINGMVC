<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
</head>
<body>
	<c:url var="url" value="/studente/list" />
	<table>

		<c:forEach items="${model}" var="tmp">
			<tr>
				<td><c:out value="${tmp.nome}" /></td>
				<td><c:out value="${tmp.cognome}" /></td>
		</c:forEach>
	</table>
	

	<hr />
	<a href="${url}">Indietro</a>
</body>
</html>