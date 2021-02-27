<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="urlDelete" value="/corsi/delete" />
<c:url var="urlEdit" value="/corsi/edit" />
<c:url var="urlInsert" value="/corsi/insert" />
<c:url var="urlView" value="/corsi/view" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Corsi</title>
</head>
<body>


	<div id="container">

		<div id="content">

			<!--   table  -->
			<table>
				<tr>
					<th><small><sup>EXO</small></sup>Corso</th>
					<th>Data Inizio
						<p>(Orario da definire)</p>
					</th>

					<th><h2>Lista Dei Corsi</h2></th>
				</tr>
			</table>
			<table>
				<!-- loop over and print -->

				<c:forEach items="${models}" var="tmp">
					<tr>
						<td><c:out value="${tmp.nomecorso}" /></td>
						<td><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>

						<td><c:out value="${tmp.datainizio}" /></td>
						<td><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
						<td><div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>

						<td><a href="${urlEdit}/${tmp.idcorsi}"> edit</a></td>
						<td><a href="${urlDelete}/${tmp.idcorsi}">delete</a></td>
						<td><a href="${urlView}/${tmp.idcorsi}"> View Students</a></td>

					</tr>

				</c:forEach>

			</table>

		</div>


		<table>
			<tr>
				<td><a href="${urlInsert}">INSERISCI NUOVO CORSO</a></td>

				<td><a href="${pageContext.request.contextPath}/index.jsp">home</a></td>
			</tr>
		</table>
	</div>



	<%-- 				<c:forEach items="${tmp.studenti}" var="tmp1"> --%>
	<!-- 				<tr> -->
	<%-- 					<td><c:out value="${tmp1.nome}" /></td> --%>
	<%-- 					<td><c:out value="${tmp1.cognome}" /></td> --%>

	<%-- 					<td><a href="${urlEdit}/${tmp1.id}">Modifica</a></td> --%>
	<%-- 					<td><a href="${urlDelete}/${tmp1.id}">Elimina</a></td> --%>

	<!-- 				</tr> -->

	<%-- 			</c:forEach> --%>



</body>
</html>