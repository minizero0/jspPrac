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
%>
<jsp:useBean id="dao" class = "com.sist.dao.BookDAO"/>
<jsp:useBean id="bv" class = "com.sist.vo.BookVO"/>
<jsp:setProperty property="*" name="bv"/>
<%
	int re = dao.updateBook(bv);
	if (re > 0){
		response.sendRedirect("bookList.jsp");
	}else{
		out.print("수정실패");
	}
%>
</body>
</html>