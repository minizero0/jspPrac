<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBoardOK.jsp" method="post">
		NO : <input type = "number" name = "no"><br>
		Writer : <input type = "text" name = "writer"><br> 
		Pwd : <input type = "text" name = "pwd"><br>
		Title :<input type = "text" name = "title"><br>
		Content : 
		<textarea rows="10" cols="60"></textarea><br>
		<input type = "submit" value = "등록">
		<input type = "reset" value = "취소">
	</form>
</body>
</html>