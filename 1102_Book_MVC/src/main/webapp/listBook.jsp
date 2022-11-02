<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><a href = "insertBook.do">게시물등록</a></h4>
	<table border = "1" width = "50%">
		<tr>
			<td>bookid</td>
			<td>bookname</td>
		</tr>
		<c:forEach items = "${list }" var = "bv">
			<tr>
				<td>${bv.bookid }</td>
				<td><a href = "detailBook.do?bookid=${bv.bookid }">${bv.bookname }</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<ul>
		
	</ul>
</body>
</html>