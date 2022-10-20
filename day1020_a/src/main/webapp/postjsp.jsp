<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Post Servlet method</h1>
	<form action="postServlet" method = "post">
		id : <input type="text" name = "id"><br>
		pwd : <input type="password" name = "pwd"><br>
		이메일 : <input type="email" name = "email"><br>
		<input type="submit" name = "send">
	</form>
</body>
</html>