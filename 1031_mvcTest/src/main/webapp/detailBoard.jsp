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
	
	<c:forEach items ="${bv}" var="b">
			<h4>글번호 : ${b.no }</h4>
			<h4>글제목 : ${b.title }</h4>
			<h4>작성자 : ${b.writer }</h4>
			<h4>글내용 :<br>
			<textarea rows="10" cols="60" readonly="readonly">${b.content }</textarea> </h4>
			<h4>조회수 : ${b.git }</h4>
			<h4>등록일 : ${b.regdate }</h4>
				
	</c:forEach>
			
			<hr>
			<h4><a href = "updateBoard.jsp?no=${b.no }">수정</a></h4>
			<h4><a href = "deleteBoard.jsp?no=${b.no }">삭제</a></h4>
			<h4><a href = "insertBoard.jsp?no=${b.no }">답글작성</a></h4>
</body>
</html>