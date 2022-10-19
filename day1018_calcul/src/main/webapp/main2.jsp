<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산기</h2><hr>
	<%
		String method = request.getMethod();
		if(method.equals("GET")){
			%>
			<form action = "main2.jsp" method = "post">
				<input type = "text" name = "num1">
				<select name = "giho">
					<option value = "+">+</option>
					<option value = "-">-</option>
					<option value = "*">*</option>
					<option value = "/">/</option>
				</select>
				<input type = "text" name = "num2">
				<input type = "submit" value = "등록">
			</form>
			<%
		}else{
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			int num1 = Integer.parseInt(request.getParameter("num1")); 
			int num2 = Integer.parseInt(request.getParameter("num2"));
			String giho = request.getParameter("giho");
			int sum = 0;
			switch(giho){
			case "+":sum = num1 + num2; break;
			case "-":sum = num1 - num2; break;
			case "*":sum = num1 * num2; break;
			case "/":sum = num1 / num2; break;
			}
			
			out.print("<h2>계산결과:"+sum);
		}
	%>
</body>
</html>