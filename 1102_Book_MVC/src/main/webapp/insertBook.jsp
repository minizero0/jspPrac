<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<hr>
	<form action="insertBookOK.do" method = "post">
	도서번호	: <input type="number" name = "bookid" required="required"><br>
	도서이름	: <input type="text" name = "bookname" required="required"><br>
	출판사	: <input type="text" name = "publisher" required="required"><br>
	도서가격 	: <input type="text" name = "price" required="required"><br>
	<input type="submit" value = "등록">
	<input type="reset" value = "취소">
	</form>
</body>
</html>