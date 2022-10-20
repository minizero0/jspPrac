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
	request.setCharacterEncoding("utf-8");
	String season  = request.getParameter("season");
	String fruit = request.getParameter("fruit");
	String id = (String)session.getAttribute("idKey");
	String sessionId = session.getId();
	int intervalTime = session.getMaxInactiveInterval();			//세션 최대 유지 시간
	
	if(id != null){
		%>
			<h1>Session Example1</h1>
			<b><%= id %></b>님이 좋아하는 계절과 과일은 <br>
			<b><%=season %></b>과 <b><%=fruit %></b>입니다.<br> 
			세션아이디 : <%= sessionId %><br>
			세션유지시간 : <%= intervalTime %>
		<% 
	}else{
		out.print("세션 시간 경과 또는 다른 이유로 연결 불가.");
	}
%>
</body>
</html>