<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("name");
String password = (String)session.getAttribute("password");

%>
<h2> User Details </h2>
<%
out.println("<h3> Name : " + name + "</h3>");
out.println("<h3> Password : " + password + "</h3>");
%>
</body>
</html>