<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 수정</h2>
	<hr>
	<form action="updateBookOK.do" method = "post">
	도서번호	: ${bv.bookid }<br>
	<input type="hidden" name = "bookid" value = "${bv.bookid }">
	도서이름	: <input type="text" name = "bookname" value = "${bv.bookname }"><br>
	출판사	: <input type="text" name = "publisher" value = "${bv.publisher }"><br>
	도서가격 	: <input type="text" name = "price" value = "${bv.price }"><br>
	<input type="submit" value = "수정">
	<input type="reset" value = "취소">
	</form>
</body>
</html>