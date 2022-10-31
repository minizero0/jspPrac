<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteBoardOK.do" method = "post">
		<input type ="hidden" name = "no" value = "${no }">
		비밀번호 : <input type = "password" name ="pwd">
		<input type="submit" value = "삭제">
	</form>
</body>
</html>