<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Web MVC Demo Home Page</title>
</head>
<body>
Messaggio: ${myMessage}<br />
In questo momento il timestamp �: <fmt:formatDate type="both" dateStyle="full" value="${myTime.time}" /><br />
<br />
<a href="/webapp-simple/addUser.html">Aggiungi un altro utente.</a>
</body>
</html>
