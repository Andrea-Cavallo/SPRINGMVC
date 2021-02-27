<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<c:url var="urllista" value="/corsi/list" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
</head>
<body>
	<c:url var="urlDettaglio" value="/dettaglio/view" />

	<div id="container">



		<div id="content">

			<!--   table  -->
			<table>
				<tr>
					<th>Studenti Iscritti</th>
					<th>al corso di : <c:out value="${model.nomecorso}"></c:out></th>
				</tr>
			</table>

			<!-- loop over and print -->
			<table>

				<c:url var="url" value="/studente/list" />

				<c:forEach items="${model.studenti}" var="tmp1">
					<tr>
						<td><c:out value="${tmp1.nominativo}" /></td>
						
						
						</tr>
            	</c:forEach>
			</table>

		</div>

		<a href="${urllista}">Torna alla lista dei corsi</a> 
	</div>
</body>
</html>