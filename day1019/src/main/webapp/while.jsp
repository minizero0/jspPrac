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
		String word =request.getParameter("word");
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		int i = 0;
		while(i<cnt){
			out.print(word+"<br>");
			i++;
		}
	%>
</body>
</html>