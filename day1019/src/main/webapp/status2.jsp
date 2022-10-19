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
		int a = (Integer)request.getAttribute("a");
		int b = (Integer)session.getAttribute("b");
		int c = (Integer)application.getAttribute("c");
	%>
	a:<%=a %><br>
	b:<%=b %><br>
	c:<%=c %><br>
</body>
</html>