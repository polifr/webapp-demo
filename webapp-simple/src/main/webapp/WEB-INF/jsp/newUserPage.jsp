<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hibernate Demo New User Page</title>
</head>
<body>

<form:form commandName="user" action="/TomcatHibernateDemo/addUser.html" method="POST">
	<table>
		<tr>
			<td>Nome:</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" /></td>
		</tr>
		<tr>
			<td>Cognome:</td>
			<td><form:input path="surname" /></td>
			<td><form:errors path="surname" /></td>
		</tr>
		<tr>
			<td>Username:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="Crea">
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>
