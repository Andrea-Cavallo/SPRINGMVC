<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="urlDelete" value="/docente/delete" />
<c:url var="urlEdit" value="/docente/edit" />
<c:url var="urlInsert" value="/docente/insert" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Docenti</title>
</head>
<body>


	<div id="container">

		<div id="content">

			<!--   table  -->
			<table>
				<tr>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nome</th>
					<th>Cognome</th>
					<th>Nome Corso</th>

					<th><h2>Lista Docenti</h2></th>
				</tr>
				</table>
				<table>

				<!-- loop over and print -->
				<c:forEach items="${models}" var="tmp">

					<tr>
						<td><c:out value="${tmp.nome}" /></td>
						<td><c:out value="${tmp.cognome}" /></td>
						<td><c:out value="${tmp.corsi.nomecorso}" /></td>

						<td><a href="${urlEdit}/${tmp.id}">edit</a></td>
						<td><a href="${urlDelete}/${tmp.id}">delete</a></td>
					</tr>

				</c:forEach>

			</table>

		</div>

		
		  <table><tr>
		<td>  <a href="${urlInsert}">INSERISCI NUOVO DOCENTE</a></td>
	
	   <td><a href="${pageContext.request.contextPath}/index.jsp"> home</a></td>
	     </tr>
	     </table>
		
		
	</div>








</body>
</html>