<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Login Page</title>
</head>
<c:url var="loginUrl" value="./adminPost"/>
<form action="${loginUrl}" method="POST">
User Name:	<input type="text"  id="username" name="ssoId" placeholder="Enter Username" required>
	<br>Password:<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    <br><input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
                          
</form>
<body>
</body>
</html>