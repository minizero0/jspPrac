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
	<table border = "1">
		<tr>
			<td>사원번호</td>
			<td>사원이름</td>
			<td>부서번호</td>
			<td>급여</td>
		</tr>
		<c:forEach items = "${list }" var = "ev">
			<tr>
				<td>${ev.eno }</td>
				<td><a href = "detailEmp.do?eno=${ev.eno }">${ev.ename }</a></td>
				<td>${ev.dno }</td>
				<td>${ev.salary }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>