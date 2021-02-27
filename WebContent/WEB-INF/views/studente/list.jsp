<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="urlDelete" value="/studente/delete" />
<c:url var="urlEdit" value="/studente/edit" />
<c:url var="urlInsert" value="/studente/insert" />
<c:url var="urlDetails" value="/dettaglio/list" />
<c:url var="urlprova" value="/dettaglio/view" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" > --%>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Studenti</title>
</head>
<body>
	
	
	<div id="container">
		<div id="home" class="flex-center ">
	            <!--  add a search box -->
            <form:form action="search" method="get" modelAttribute="models">
                Cerca Studente per Nome: <input type="text" name="nomeCercato" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
                 <!--  add a search box -->
            <form:form action="search" method="get" modelAttribute="models">
                Cerca Studente per Cognome: <input type="text" name="cognomeCercato" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		<div id="content">
		
			<!--   table  -->
			<table>
				<tr>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nome&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cognome</th>
					<th>Lista Studenti</th>
				</tr>
				</table>
				<table>
				<!-- loop over and print -->
				<c:forEach items="${models}" var="tmp">
				
					<tr>
				  <td><c:out value="${tmp.nome}" /></td>
					<td><c:out value="${tmp.cognome}" /></td>
					<td><a href="${urlprova}/${tmp.id}"> prova    </a></td>

					<td><a href="${urlEdit}/${tmp.id}"> edit     </a></td>
					<td><a href="${urlDelete}/${tmp.id}" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">delete  </a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		
		  		</div>
		  <table><tr>
		<td>  <a href="${urlInsert}">INSERISCI NUOVO STUDENTE</a></td>
			<td>  <a href="${urlDetails}">DETTAGLI STUDENTi</a></td>
	
	   <td><a href="${pageContext.request.contextPath}/index.jsp"> home</a></td>
	     </tr>
	     </table>
	     </div>
	</div>



		





	
</body>
</html>