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
		int a = 1;
		int b = 1;
		
		a++;
		b++;
		session.setAttribute("a", a);
		application.setAttribute("b", b);
	%>						
</body>
</html>