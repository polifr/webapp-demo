<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Web MVC Demo List Users Page</title>
</head>
<body>

Utenti:<br />
<table>
	<tr>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Username</th>
		<th>Email</th>
		<th>Gruppo</th>
	</tr>
	<c:forEach items="${model.users}" var="user">
	<tr>
		<td><c:out value="${user.name}" /></td>
		<td><c:out value="${user.surname}" /></td>
		<td><c:out value="${user.username}" /></td>
		<td><c:out value="${user.email}" /></td>
		<td><c:out value="${user.userGroup.name}" /></td>
	</tr>
	</c:forEach>
</table>

<br />
<br />
<a href="/TomcatHibernateDemo/addUser.html">Aggiungi un altro utente.</a>

</body>
</html>
