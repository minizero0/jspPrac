<%@page import="com.sist.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.BoardDAO"/>
<jsp:useBean id="vo" class = "com.sist.vo.BoardVO"></jsp:useBean>
	<%
		if(request.getParameter("no")!=null){
			int no =  Integer.parseInt(request.getParameter("no")); 
			vo = dao.findByNo(no);
		}
	%>
	no :<h4><%=vo.getNo() %></h4>
	title :<h4><%=vo.getTitle() %></h4>
	writer :<h4><%=vo.getWriter() %></h4>
	content :<h4><%=vo.getContent() %></h4>
	regdate :<h4><%=vo.getRegdate() %></h4>
	hit : <h4><%=vo.getHit() %></h4>
</body>
</html>