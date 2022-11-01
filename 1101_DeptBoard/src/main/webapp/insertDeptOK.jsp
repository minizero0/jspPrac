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
	<c:if test = "${re == 1 }">
		게시물 등록 성공
	</c:if>
	<c:if test = "${re != 1 }">
		게시물 등록 실패
	</c:if>
	<h4><a href = "listDept.do">게시물 목록</a></h4>
</body>
</html>