<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Hello?name=홍길동&age=20">hello</a>
	<hr>
	<form action="Hello">
		<input type = "text" name ="name"> <br>
		<input type = "text" name ="age"> <br>
		<input type = "submit" value = "Hello">
	</form>
	<hr>
	<form action="Hello" method = "post">
	<input type = "text" name ="name"> <br>
		<input type = "text" name ="age"> <br>
		<input type = "submit" value = "Hello POST">
	</form>
</body>
</html>