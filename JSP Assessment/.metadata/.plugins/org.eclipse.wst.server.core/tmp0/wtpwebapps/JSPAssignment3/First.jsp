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

String name = request.getParameter("name");
String password = request.getParameter("password");

session.setAttribute("name",name);
session.setAttribute("password",password);

%>

<h4><a href = "Second.jsp">  Click here for Stored Details </a></h4>

</body>
</html>