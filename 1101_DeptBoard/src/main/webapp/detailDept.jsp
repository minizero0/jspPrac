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
	<h4>부서번호 : ${dv.dno }</h4>
	<h4>부서이름 : ${dv.dname }</h4>
	<h4>부서위치 : ${dv.dloc }</h4>
	<a href = "listDept.do">게시물 목록</a>
</body>
</html>