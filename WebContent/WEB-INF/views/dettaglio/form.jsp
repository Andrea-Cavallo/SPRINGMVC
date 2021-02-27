<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/app.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli Form</title>
</head>
<body>

	<c:url var="urlBack" value="/dettaglio/list" />
	<c:url var="url" value="/dettaglio/insert" />
	<c:if test="${model.matricola>0 }">
		<c:url var="url" value="/dettaglio/update" />
	</c:if>

	<form:form action="${url}" method="post" modelAttribute="model">

		<c:if test="${model.matricola>0 }">
			<input type="hidden" name="id" value="${model.matricola}" />
		</c:if>

		<br />
		<form:input path="idstudente" />
		<input type="hidden" name="id" />
		<br />

		<br />
		<form:input path="cap" placeholder="Cap" />
		<br />


		<form:input path="citta" placeholder="Città" />
		<br />

		<form:input path="datadinascita" type="date"
			placeholder="data di Nascita" />
		<br />

		<input type="submit" value="Invia" />
		<br />

		<form:errors path="*" cssClass="error" />
		<a href="${urlBack}">Visualizza dettagli Studenti</a>
		<jsp:include page="../common/footer.jsp" />
	</form:form>
	<br />


</body>
</html>