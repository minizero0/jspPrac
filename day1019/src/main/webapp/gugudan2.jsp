<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gugudan2.jsp" method = "post">
	출력할 구구단 입력 : <input type = "number" name = "num">
	<input type = "submit" value = "출력">
	</form>
	<%
	
	String method = request.getMethod();
	if(method.equals("POST")){	
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		out.print("<h1>"+num+"단</h1>");
		for (int i = 1; i <10; i++){
			out.print(num + "*" + i + "=" + (num*i)+ "<br>");
		}
	}
		
		
	
	%>
</body>
</html>