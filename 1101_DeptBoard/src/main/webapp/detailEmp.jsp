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
	<h4>사원번호 : ${ev.eno }</h4>
	<h4>사원이름 : ${ev.ename }</h4>
	<h4>부서번호 : ${ev.dno }</h4>
	<h4>사원급여 : ${ev.salary }</h4>
	<h4>전화번호 : ${ev.phone }</h4>
	<h4>이메일 : ${ev.email }</h4>
	<hr>
	<a href = "updateEmp.do?no=${ev.eno }">수정하기</a><br>
	<a href = "#" onclick = "checkDelete(${ev.eno })">삭제하기</a><br>
	<hr>
	<a href = "listEmp.do">게시물 목록</a>
</body>
</html>