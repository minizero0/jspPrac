<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 상세보기</h2>
	<hr>
	<h4>도서번호 : ${bv.bookid }</h4>
	<h4>도서이름 : ${bv.bookname }</h4>
	<h4>출판사 : ${bv.publisher }</h4>
	<h4>도서가격 : ${bv.price }</h4>
	<hr>
	<a href = "listBook.do">게시물 목록</a>
</body>
</html>