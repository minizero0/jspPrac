<%@page import="com.sist.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<jsp:useBean id="dao" class = "com.sist.dao.BookDAO"/>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String bookname = request.getParameter("bookname");
		BookVO bv = dao.findByName(bookname);
	%>
	<h2>bookid : <%= bv.getBookid() %></h2>
	<h2>bookname : <%=  bv.getBookname() %></h2>
	<h2>publisher : <%= bv.getPublisher() %></h2>
	<h2>price : <%= bv.getPrice() %></h2>
</body>
</html>