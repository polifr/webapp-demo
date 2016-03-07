<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hibernate Demo Search Users Page</title>
</head>
<body>

<form:form commandName="user" action="/webapp-simple/searchUsers.html" method="POST">
	<table>
		<tr>
			<td>Nome:</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Cognome:</td>
			<td><form:input path="surname" /></td>
		</tr>
		<tr>
			<td>Username:</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Cerca">
			</td>
		</tr>
	</table>
</form:form>
<br />
<br />

<c:choose>
	<c:when test="${users eq null}"></c:when>
	<c:when test="${fn:length(users) eq 0}">Nessun risultato trovato.</c:when>
	<c:otherwise>
		<table>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Username</th>
				<th>Email</th>
			</tr>
			<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.surname}" /></td>
				<td><c:out value="${user.username}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>


</body>
</html>
