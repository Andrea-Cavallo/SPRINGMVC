<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<c:url var="urllista" value="/dettaglio/list" />

<html>
<head>
<meta charset="UTF-8">
<title>Vista Dettagli</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
</head>
<body>

	<div id="container">



		<div id="content">

			<!--   table  -->
			<table>
				<tr>
					<th>Studenti Dettaglio</th>
				</tr>
			</table>

			<!-- loop over and print -->
			<table>

				<c:url var="urlDettaglio" value="/dettaglio/list" />

				<%-- 				<c:forEach items="${model}" var="tmp1"> --%>
				<tr>
					<td><c:out value="${model.matricola}" /></td>
					
					<td><c:out value="${model.cap}" /></td>
					<td><c:out value="${model.citta}" /></td>
					<td><c:out value="${model.datadinascita}" /></td>
					
					<p>prova</p>


				</tr>
				<%-- 				</c:forEach> --%>
			</table>

		</div>

		<a href="${urllista}">Torna alla lista dettagli</a>
	</div>
</body>
</html>