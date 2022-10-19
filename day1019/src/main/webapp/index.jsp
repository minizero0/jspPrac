<%@page import="com.sist.vo.MemberVO"%>
<%@page import="com.sist.dao.MemberDAO1"%>
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
		if(session.getAttribute("login") == null || !session.getAttribute("login").equals("yes"))
		{
			response.sendRedirect("login.html");
		}
	%>
	<h2>서비스 문서입니다.</h2>
	<hr>
</body>
</html>