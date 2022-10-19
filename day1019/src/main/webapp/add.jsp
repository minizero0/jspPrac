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
		String method = request.getMethod();
	
		if (method.equals("GET")){
			%>
			<form action="add.jsp" method = "post">
			<input type = "number" name = "num">
			<input type = "submit" value = "보내기">
			</form>
			<%
		}else{
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			int sum = 0;
			for (int i = 1; i<=num;i++){
				sum +=i;
				out.print(i);
				if (i < num)
					out.print("+");
				else
					out.print("=" + sum);
			}
			
		}
	%>
</body>
</html>