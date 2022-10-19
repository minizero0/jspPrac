<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String c = request.getParameter("color");
	String color = "";
	if(c.equals("빨강"))
		color = "red";
	else if(c.equals("초록"))
		color = "green";
	else if(c.equals("파랑"))
		color = "blue";
%>

<body bgcolor = "<%= color%>">
	<h1>If-else Example</h1>
	<p><%=name %>님이 좋아하는 색깔은<b><%=c %>색 입니다.</b></p>
</body>
</html>