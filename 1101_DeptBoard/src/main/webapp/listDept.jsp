<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<h4><a href = "insertDept.do">게시물 등록</a></h4>
	<hr>
	<table border = "1">
		<tr>
			<td>DNO</td>
			<td>DNAME</td>
			<td>DLOC</td>
		</tr>
		<c:forEach items = "${list }" var = "bv">
			<tr>
				<td>${bv.dno }</td>
				<td>${bv.dname }</td>
				<td>${bv.dloc }</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>