<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="dao" class ="com.sist.dao.BookDAO"/>
<body>
	<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	int re = dao.deleteBook(bookid);
	
	if(re > 0)
		response.sendRedirect("bookList.jsp");
	else
		out.print("삭제실패");
	%>
</body>
</html>