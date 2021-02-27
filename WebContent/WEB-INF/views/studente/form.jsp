<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/resources/css/app.css"
	rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Studente Form</title>
</head>
<body>

	<c:url var="urlBack" value="/studente/list" />

	<c:url var="url" value="/studente/insert" />
	<c:if test="${model.id>0 }">
		<c:url var="url" value="/studente/update" />
	</c:if>

	<form:form action="${url}" method="post" modelAttribute="model">

		<c:if test="${model.id>0 }">
			<input type="hidden" name="id" value="${model.id}" />
		</c:if>

		<br />
		<form:input path="nome" placeholder="Nome Studente"
			required="required" />
		<br />
		<form:errors path="nome" cssClass="error" />
		<br />

		<form:input path="cognome" placeholder="Cognome Studente"
			required="required" />
		<br />
		<br />
		<input type="submit" value="Invia" />
		<br />
		<br />
		<a href="${urlBack}">Indietro</a>
		<jsp:include page="../common/footer.jsp" />


		<form:errors path="*" cssClass="error" />
	</form:form>
	<br />
</body>
</html>