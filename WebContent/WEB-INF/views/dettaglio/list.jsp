<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="urlDelete" value="/dettaglio/delete" />
<c:url var="urlEdit" value="/dettaglio/edit" />
<c:url var="urlInsert" value="/dettaglio/insert" />



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio</title>
</head>
<body>


	<div id="container">

		<div id="content">

			<!--   table  -->
			<table>
				<tr>
					<th>Matricola</th>
					<th>Cap</th>
					<th>Città e Data di Nascita</th>

					<th><h2>Dettagli Studente</h2></th>
				</tr>
			</table>
			<table>
				<!-- loop over and print -->

				<c:forEach items="${models}" var="tmp">
					<tr>
						<td><c:out value="${tmp.matricola}" /></td>

						<td>00<c:out value="${tmp.cap}" /></td>

						<td><c:out value="${tmp.citta}" /></td>

						<td><c:out value="${tmp.datadinascita}" /></td>

						<td><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>




						<td><a href="${urlEdit}/${tmp.matricola}"> edit</a></td>
						<td><a href="${urlDelete}/${tmp.matricola}">delete</a></td>

					</tr>

				</c:forEach>

			</table>

		</div>


		<table>
			<tr>
				<td><a href="${urlInsert}">Inserisci Nuovo Dettaglio</a></td>

				<td><a href="${pageContext.request.contextPath}/index.jsp">home</a></td>
			</tr>
		</table>
	</div>



</body>
</html>