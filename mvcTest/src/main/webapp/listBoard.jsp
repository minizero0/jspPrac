<%@page import="java.util.HashMap"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<form action="listBoard.do">
		<select name = "searchColumn">
			<option value = "writer">작성자</option>
			<option value = "title">글제목</option>
			<option value = "content">글내용</option>
		</select>
		<input type = "search" name = "keyword">
		<input type = "submit" value="검색">
	</form>
	
	<table border = "1" width = "60%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach items ="${list}" var="b">
		<tr>
			<td>${b.no}</td>
			<td><a href = "DetailBoard.do?no=${b.no }">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.hit}</td>
			<td>${b.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<c:forEach var = "i" begin ="1" end="${totalPage }">		<!-- begin부터 end까지 반복 -->
			<a href = "listBoard.do?pageNUM=${i }">${i }</a>&nbsp;
		</c:forEach>
	
</body>
</html>