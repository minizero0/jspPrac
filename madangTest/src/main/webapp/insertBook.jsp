<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBookProcess.jsp" method = "post">
		bookid : <input type = "number" name = "bookid"><br>
		bookname : <input type = "text" name = "bookname"><br>
		publisher : <input type = "text" name = "publisher"><br>
		price : <input type = "number" name = "price">
		<input type="submit" value = "등록">
		<input type="reset" value = "취소">
	</form>
	
</body>
</html>