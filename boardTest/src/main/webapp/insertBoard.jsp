<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 등록</h2>
	<hr>
	<form action="insertBoardOK.jsp" method="post">
		작성자 : <input type = "text" name = "writer"><br> 
		글암호 : <input type = "password" name = "pwd"><br>
		글제목 : <input type = "text" name = "title"><br>
		글내용 : 
		<textarea rows="10" cols="60" name = "content"></textarea><br>
		<input type = "submit" value = "등록">
		<input type = "reset" value = "취소">
	</form>
</body>
</html>