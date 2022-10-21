<%@page import="com.sist.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class = "com.sist.dao.BookDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	BookVO bv = dao.findById(bookid);
	
%>

<form action="updateBookProcess.jsp" method = "post">
	bookid : <%= bv.getBookid() %><br>
	<input type = "hidden" name = "bookid" value = "<%= bv.getBookid() %>">
	bookname : <input type = "text" name = "bookname" value ="<%= bv.getBookname() %>"><br>
	publisher : <input type = "text" name = "publisher" value ="<%= bv.getPublisher() %>"><br>
	price : <input type = "number" name = "price" value = "<%= bv.getPrice()%>"><br>
	<input type="submit" value = "수정">
	<input type="reset" value = "취소">
</form>


</body>
</html>