<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee.com</title>
</head>
<body>
  <h2>Spring Security</h2>
  <hr />
  <h4>${message}</h4>
  <br>
  <a href='<spring:url value="/signout"/>'>Logout</a>
</body>
</html>