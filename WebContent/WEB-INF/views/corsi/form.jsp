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
<title>Corsi Form</title>
</head>
<body>

	<c:url var="urlBack" value="/corsi/list" />
	<c:url var="url" value="/corsi/insert" />
	<c:if test="${model.idcorsi>0 }">
		<c:url var="url" value="/corsi/update" />
	</c:if>

	<form:form action="${url}" method="post" modelAttribute="model">

		<c:if test="${model.idcorsi>0 }">
			<input type="hidden" name="id" value="${model.idcorsi}" />
		</c:if>





		<!-- 		<br /> -->
		<!-- 		<label>Id_Corso:</label> -->
		<!-- 		<br /> -->
		<%-- 		<form:input path="idcorsi" /> --%>
		<!-- 		<br /> -->
		<!-- 		<br /> -->



		<br />
		<form:input path="nomecorso" placeholder="ExoCorso"
			required="required" />
		<br />
		<form:errors path="nomecorso" cssClass="error" />

		<form:input path="datainizio" type="date" placeholder="data Inizio" />
		<br />

		<input type="submit" value="Invia" />
		<br />

		<form:errors path="*" cssClass="error" />
		<a href="${urlBack}">Visualizza i corsi</a>
	<jsp:include page="../common/footer.jsp" />
	</form:form>
	<br />
	

</body>
</html>