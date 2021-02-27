<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	background-color: #ff0000;
	padding: 5px;
	color: #ffFFFF;
	font-size: 13px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="${pageContext.request.contextPath}/resources/css/app.css"
	rel="stylesheet">

</head>
<body>

	<p>${err}</p>
	<c:url var="url" value="/area-riservata/login" />
	
<%-- 	<c:if test="${param.error != null}"> --%>
		
<!-- 			<i class="failed">Sorry! You entered invalid username/password.</i> -->
			
<%-- 		</c:if> --%>
	

	<form:form action="${url}" method="post" modelAttribute="model">
		<label>Email:</label>
		<br />
		<form:input path="email" placeholder="email " required="required" />
		<br />
		<label>Password:</label>
		<br />
		<form:input path="password" type="password" placeholder="password"
			required="required" />


		<br />
		<br />
		<input type="submit" value="Invia" />
		<br />
		<br />
		<form:errors path="*" cssClass="error" />
	</form:form>
</html>