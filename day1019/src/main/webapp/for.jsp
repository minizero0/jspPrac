<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>For Example</h1>
	<h2>1에서 10까지 합은?</h2>
	<hr>
	<%
	int sum = 0;
	for (int i = 1; i <= 10; i++){
		sum += i;
		out.print(i);
		if(i != 10)
			out.print("+");
		else
			out.print("=" + sum);
	}
	%>
</body>
</html>